package com.example.apporder.controller;

import com.example.apporder.entity.Customer;
import com.example.apporder.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers_without_orders")
    public List<Customer> getAllCustomersWithoutOrders(@RequestParam("year") String year) {
        return customerService.getAllCustomersWithoutOrders(year);
    }


}
