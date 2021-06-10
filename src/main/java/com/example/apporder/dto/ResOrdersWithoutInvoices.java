package com.example.apporder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResOrdersWithoutInvoices {

    private Integer orderId;
    private Date orderDate;
    private Double totalPrice;
    private Integer quantity;


}
