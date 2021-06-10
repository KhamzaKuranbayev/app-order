package com.example.apporder.service;

import com.example.apporder.dto.res.ResPayment;
import com.example.apporder.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    ResPayment makePayment(Integer invoiceId);

    Payment getPaymentDetails(Integer paymentId);
}
