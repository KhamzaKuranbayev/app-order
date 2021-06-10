package com.example.apporder.controller;

import com.example.apporder.dto.ResInvoice;
import com.example.apporder.dto.ResOrder;
import com.example.apporder.dto.Response;
import com.example.apporder.entity.Order;
import com.example.apporder.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Make Order
    @PostMapping
    public ResInvoice makeOrder(@RequestParam("customer_id") Integer customerId,
                                @RequestParam("product_id") Integer productId,
                                @RequestParam("quantity") Integer qty) {
        return orderService.makeOrder(customerId, productId, qty);
    }

    // Get order details by id
    @GetMapping("/details")
    public ResOrder getOrderDetails(@RequestParam("order_id") Integer orderId) {
        return orderService.getOrderDetails(orderId);
    }

    @GetMapping("/orders_without_details")
    public List<Order> getOrdersWithoutDetails(@RequestParam("date") Date date) {
        return orderService.getOrdersWithoutDetails(date);
    }

    @GetMapping("/customers_last_orders")
    public Order getCustomersLastOrder(@RequestParam("id") Integer customerId,
                                       @RequestParam("name") String name,
                                       @RequestParam("date") String date) {
        // @RequestParam("date") String date  --> '2021-06-09'
        return orderService.getCustomersLastOrder(customerId, name, date);
    }

    @GetMapping("/orders_without_invoices")
    public Response getOrdersWithoutInvoices() {
        return orderService.ordersWithoutInvoices();
    }


}
