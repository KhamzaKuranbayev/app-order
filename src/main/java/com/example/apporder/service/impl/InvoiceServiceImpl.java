package com.example.apporder.service.impl;

import com.example.apporder.dto.OverpaidInvoicesDto;
import com.example.apporder.dto.res.Response;
import com.example.apporder.entity.Invoice;
import com.example.apporder.repository.InvoiceRepository;
import com.example.apporder.repository.PaymentRepository;
import com.example.apporder.service.InvoiceService;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    final InvoiceRepository invoiceRepository;
    final PaymentRepository paymentRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              PaymentRepository paymentRepository) {
        this.invoiceRepository = invoiceRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Invoice> getExpiredInvoices() {
        return invoiceRepository.getAllExpired();
    }

    @SneakyThrows
    @Override
    public Response getOverpaidInvoices() {

        List<OverpaidInvoicesDto> overpaidInvoicesDtoList = new ArrayList<>();
        List<Integer> byInvoice = paymentRepository.getByInvoice();
        for (Integer integer : byInvoice) {
            Invoice invoice = invoiceRepository.findById(integer).orElseThrow(() -> new NotFoundException("invoice"));
            Double byInvoiceId = paymentRepository.getByInvoiceId(invoice.getId());

            if (invoice.getAmount()<byInvoiceId)
                overpaidInvoicesDtoList.add(new OverpaidInvoicesDto(invoice.getId(),invoice.getAmount(),byInvoiceId));
        }

        return new Response("Ok!", true, overpaidInvoicesDtoList);
    }

    @Override
    public Response getWrongDateInvoices() {
        List<Invoice> invoices = invoiceRepository.getWrongDateInvoices();
        return new Response("Ok!", true, invoices);
    }
}
