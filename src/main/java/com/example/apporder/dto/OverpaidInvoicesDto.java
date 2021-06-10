package com.example.apporder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverpaidInvoicesDto {

    private Integer invoiceId;
    private Double reimbursedAmount;
    private Double paid;



}
