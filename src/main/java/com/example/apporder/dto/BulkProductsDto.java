package com.example.apporder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulkProductsDto {

    private Integer productId;
    private Integer orderId;
    private Double price;



}
