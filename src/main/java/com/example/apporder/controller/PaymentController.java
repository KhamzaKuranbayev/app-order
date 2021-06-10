package com.example.apporder.controller;

import com.example.apporder.dto.res.ResPayment;
import com.example.apporder.entity.Payment;
import com.example.apporder.service.PaymentService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResPayment makePayment(@RequestParam("invoice_id") Integer invoiceId) {
        return paymentService.makePayment(invoiceId);
    }

    @GetMapping("/details")
    public Payment getPaymentDetails(@RequestParam("payment_id") Integer paymentId) {
        return paymentService.getPaymentDetails(paymentId);
    }
}
