package com.example.apporder.service;

import com.example.apporder.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> getAllCustomersWithoutOrders(String year);

}
