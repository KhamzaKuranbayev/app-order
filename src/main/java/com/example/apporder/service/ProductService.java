package com.example.apporder.service;

import com.example.apporder.entity.Category;
import com.example.apporder.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findAll();

    Product findOneById(Integer productId);
}