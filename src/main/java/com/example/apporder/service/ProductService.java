package com.example.apporder.service;

import com.example.apporder.dto.Response;
import com.example.apporder.entity.Category;
import com.example.apporder.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findAll();

    Product findOneById(Integer productId);

    Response getHighDemandProducts();

    Response getNumberOfProductsInYear(String year);

    Response getBulkProducts();
}
