package com.example.apporder.service.impl;

import com.example.apporder.dto.ResOverPaidInvoice;
import com.example.apporder.entity.Invoice;
import com.example.apporder.repository.InvoiceRepository;
import com.example.apporder.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getExpiredInvoices() {
        return invoiceRepository.getAllExpired();
    }

    @Override
    public List<ResOverPaidInvoice> getOverpaidInvoices() {



        return null;
    }
}
