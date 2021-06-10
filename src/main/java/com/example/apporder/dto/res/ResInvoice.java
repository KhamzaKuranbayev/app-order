package com.example.apporder.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResInvoice {

    private String status;              // SUCCESS or FAILED
    private Integer invoice_number;

    public ResInvoice(String status) {
        this.status = status;
    }

}
