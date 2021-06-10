package com.example.apporder.controller;

import com.example.apporder.dto.Response;
import com.example.apporder.entity.Product;
import com.example.apporder.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get products list
    @GetMapping("/list")
    public List<Product> findAll() {
        return productService.findAll();
    }

    // Get product details by id
    @GetMapping
    public Product findOneById(@RequestParam(name = "product_id") Integer productId) {
        return productService.findOneById(productId);
    }

    @GetMapping("/high_demand_products")
    public Response getHighDemandProducts() {
        return productService.getHighDemandProducts();
    }

    @GetMapping("/number_of_products_in_year")
    public Response getNumberOfProductsInYear(@RequestParam("year") String year) {
        return productService.getNumberOfProductsInYear(year);
    }

    @GetMapping("/bulk_products")
    public Response getBulkProducts(){
        return productService.getBulkProducts();
    };

}
