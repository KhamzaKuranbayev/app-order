package com.example.apporder.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResOverPaidInvoice {

    private Integer invoice_number;
    private Double amount;

}
