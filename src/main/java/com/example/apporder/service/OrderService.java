package com.example.apporder.service;

import com.example.apporder.dto.ResOrder;
import com.example.apporder.dto.ResInvoice;
import com.example.apporder.dto.Response;
import com.example.apporder.entity.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {

    ResInvoice makeOrder(Integer customerId, Integer productId, Integer qty);

    ResOrder getOrderDetails(Integer orderId);

    List<Order> getOrdersWithoutDetails(Date date);

    Order getCustomersLastOrder(Integer customerId, String name, String date);

    Response ordersWithoutInvoices();
}
