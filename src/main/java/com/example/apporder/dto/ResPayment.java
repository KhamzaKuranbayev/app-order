package com.example.apporder.dto;

import com.example.apporder.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResPayment {

    private String payment_status;             // “SUCCESS” or “FAILED”
    private Payment payment_details;           // All payments table rows of created payment

    public ResPayment(String payment_status) {
        this.payment_status = payment_status;
    }
}
