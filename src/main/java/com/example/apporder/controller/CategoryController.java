package com.example.apporder.controller;

import com.example.apporder.dto.res.Response;
import com.example.apporder.entity.Category;
import com.example.apporder.service.CategoryService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id) {
        return categoryService.findById(id);

    }

    @PostMapping
    public Response save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Response edit(@PathVariable Integer id, @RequestBody Category category) {
        return categoryService.edit(id, category);
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable Integer id) {
        return categoryService.deleteById(id);
    }

}
