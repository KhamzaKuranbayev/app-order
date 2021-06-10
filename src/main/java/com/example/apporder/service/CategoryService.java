package com.example.apporder.service;

import com.example.apporder.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAll();

    Category findOneByProductId(Integer productId);
}
