package com.example.apporder.dto;

import com.example.apporder.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResOrder {

    private boolean success;
    private Order order;
    private String product_name;

    public ResOrder(boolean success) {
        this.success = success;
    }
}
