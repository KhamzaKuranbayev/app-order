package com.example.apporder.service.impl;

import com.example.apporder.entity.Customer;
import com.example.apporder.repository.CustomerRepository;
import com.example.apporder.repository.OrderRepository;
import com.example.apporder.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;
    final OrderRepository orderRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Customer> getAllCustomersWithoutOrders(String year) {
        customerRepository.getAllWithoutOrders(year + "-01-01", year + "-12-01");
        return null;
    }
}
