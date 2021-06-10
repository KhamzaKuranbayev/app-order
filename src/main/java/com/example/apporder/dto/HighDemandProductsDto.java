package com.example.apporder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighDemandProductsDto {

    private Integer productId;
    private Integer count;
}
