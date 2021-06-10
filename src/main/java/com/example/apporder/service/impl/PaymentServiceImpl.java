package com.example.apporder.service.impl;

import com.example.apporder.dto.ResPayment;
import com.example.apporder.entity.Invoice;
import com.example.apporder.entity.Payment;
import com.example.apporder.repository.InvoiceRepository;
import com.example.apporder.repository.PaymentRepository;
import com.example.apporder.service.PaymentService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    final PaymentRepository paymentRepository;
    final InvoiceRepository invoiceRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              InvoiceRepository invoiceRepository) {
        this.paymentRepository = paymentRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @SneakyThrows
    @Override
    public ResPayment makePayment(Integer invoiceId) {

        Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
        if (optionalInvoice.isEmpty())
            return new ResPayment("FAILED");

        Payment payment = new Payment(
                Timestamp.valueOf(LocalDateTime.now()),
                optionalInvoice.get().getAmount(),
                optionalInvoice.get()
        );

        paymentRepository.save(payment);

        return new ResPayment("SUCCESS", payment);
    }

    @Override
    public Payment getPaymentDetails(Integer paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElse(new Payment());
    }
}
