package com.example.apporder.service.impl;

import com.example.apporder.dto.HighDemandProductsDto;
import com.example.apporder.dto.OrdersByCountryDto;
import com.example.apporder.dto.Response;
import com.example.apporder.entity.Product;
import com.example.apporder.repository.CustomerRepository;
import com.example.apporder.repository.DetailRepository;
import com.example.apporder.repository.OrderRepository;
import com.example.apporder.repository.ProductRepository;
import com.example.apporder.service.ProductService;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;
    final OrderRepository orderRepository;
    final CustomerRepository customerRepository;
    final DetailRepository detailRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              OrderRepository orderRepository,
                              CustomerRepository customerRepository,
                              DetailRepository detailRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.detailRepository = detailRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOneById(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(new Product());
    }

    @Override
    public Response getHighDemandProducts() {
        List<HighDemandProductsDto> highDemandProductsDtoList = new ArrayList<>();
        List<Product> all = productRepository.findAll();
        all.forEach(product -> {
            Integer orderCountByProductId = orderRepository.getOrderCountByProductId(product.getId());
            if (orderCountByProductId > 10) {
                highDemandProductsDtoList.add(new HighDemandProductsDto(product.getId(), orderCountByProductId));
            }
        });
        return new Response("Ok!", true, highDemandProductsDtoList);
    }

    @Override
    public Response getNumberOfProductsInYear(String year) {

        String start = year + "-01-01T00:00:00";
        String finish = year + "-12-31T23:59:59";

        List<OrdersByCountryDto> ordersByCountries = new ArrayList<>();
        List<String> countryCodes = customerRepository.getCountryCodes();
        countryCodes.forEach(countryCode -> {
            Integer countOrdersByCountry = orderRepository.getCountOrdersByCountry(start, finish, countryCode);
            if (countOrdersByCountry > 0)
                ordersByCountries.add(new OrdersByCountryDto(countOrdersByCountry, countryCode));
        });
        return new Response("Ok!", true, ordersByCountries);
    }

    @SneakyThrows
    @Override
    public Response getBulkProducts() {
        Set<Product> bulkProducts = new HashSet<>();
        List<Product> all = productRepository.findAll();
        List<Integer> productIds = detailRepository.listOfProductIds();
        for (Integer productId : productIds) {
            Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("product"));
            bulkProducts.add(product);
        }
        return new Response("Ok!", true, bulkProducts);
    }


}
