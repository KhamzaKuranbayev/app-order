package com.example.apporder.service.impl;

import com.example.apporder.entity.Category;
import com.example.apporder.repository.CategoryRepository;
import com.example.apporder.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findOneByProductId(Integer productId) {
        Category category = categoryRepository.findByProductId(productId);
        if (category != null)
            return category;
        return new Category();
    }
}
