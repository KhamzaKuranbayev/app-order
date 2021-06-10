package com.example.apporder.controller;

import com.example.apporder.entity.Category;
import com.example.apporder.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Get all products category lists
    @GetMapping("/list")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    // Get product category by id
    @GetMapping
    public Category findOneByProductId(@RequestParam(name = "product_id") Integer productId) {
        return categoryService.findOneByProductId(productId);
    }
}
