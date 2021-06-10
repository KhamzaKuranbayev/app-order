package com.example.apporder.service.impl;

import com.example.apporder.dto.ResInvoice;
import com.example.apporder.dto.ResOrder;
import com.example.apporder.dto.ResOrdersWithoutInvoices;
import com.example.apporder.dto.Response;
import com.example.apporder.entity.Detail;
import com.example.apporder.entity.Invoice;
import com.example.apporder.entity.Order;
import com.example.apporder.entity.Product;
import com.example.apporder.repository.*;
import com.example.apporder.service.OrderService;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    final OrderRepository orderRepository;
    final InvoiceRepository invoiceRepository;
    final CustomerRepository customerRepository;
    final ProductRepository productRepository;
    final DetailRepository detailRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            InvoiceRepository invoiceRepository,
                            CustomerRepository customerRepository,
                            ProductRepository productRepository,
                            DetailRepository detailRepository) {
        this.orderRepository = orderRepository;
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.detailRepository = detailRepository;
    }

    @SneakyThrows
    @Override
    public ResInvoice makeOrder(Integer customerId, Integer productId, Integer qty) {

        Order order = new Order(
                new Date(System.currentTimeMillis()),
                customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("customer"))
        );
        // ORDER SAVED
        Order savedOrder = orderRepository.save(order);

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty())
            return new ResInvoice("FAILED");

        Detail detail = new Detail(
                savedOrder,
                optionalProduct.get(),
                qty
        );
        // DETAIL SAVED
        detailRepository.save(detail);

        Double amount = optionalProduct.get().getPrice() * qty;
        Date issue = new Date(System.currentTimeMillis());
        Date due = addDays(issue, 15);                  // YOU CAN CHANGE DUE LIMIT

        Invoice invoice = new Invoice(
                savedOrder,
                amount,
                issue,
                due
        );
        Invoice savedInvoice = invoiceRepository.save(invoice);

        return new ResInvoice("SUCCESS", savedInvoice.getId());
    }

    @Override
    public ResOrder getOrderDetails(Integer orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isEmpty())
            return new ResOrder(false);

        Detail detail = detailRepository.findByOrderId(orderId);
        if (detail == null)
            return new ResOrder(false);

        return new ResOrder(true, optionalOrder.get(), detail.getProduct().getName());
    }

    @Override
    public List<Order> getOrdersWithoutDetails(Date date) {
        return orderRepository.getOrdersWithoutDetails(date);
    }

    @Override
    public Order getCustomersLastOrder(Integer customerId, String name, String date) {
        return orderRepository.getCustomersLastOrder(customerId, name, date + " 00:00:01", date + " 23:59:59");
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    @Override
    public Response ordersWithoutInvoices() {
        List<ResOrdersWithoutInvoices> ordersWithoutInvoices = new ArrayList<>();

        List<Order> orderList = orderRepository.findAll();
        List<Integer> ordersByOrderId = orderRepository.getOrdersByOrderId();
        List<Integer> orderIds = orderRepository.listOfOrderIds();
        orderList.forEach(order -> {
            Double listOfDetailsByOrderId;
            listOfDetailsByOrderId = detailRepository.getListOfDetailsByOrderId(order.getId());
            Integer quantityByOrderId;
            quantityByOrderId = detailRepository.getQuantityByOrderId(order.getId());
            if (ordersByOrderId.contains(order.getId())) {
                return;
            }
            if (!orderIds.contains(order.getId())) {
                return;
            }
            ordersWithoutInvoices.add(new ResOrdersWithoutInvoices(order.getId(), order.getDate(), listOfDetailsByOrderId, quantityByOrderId));
        });

        return new Response("Ok!", true, ordersWithoutInvoices);

    }
}
