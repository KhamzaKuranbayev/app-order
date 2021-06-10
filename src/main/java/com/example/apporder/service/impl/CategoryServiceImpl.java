package com.example.apporder.service.impl;

import com.example.apporder.dto.Response;
import com.example.apporder.entity.Category;
import com.example.apporder.repository.CategoryRepository;
import com.example.apporder.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Response findById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty())
            return new Response("Not found!", false);

        return new Response("Success!", true, optionalCategory.get());
    }

    @Override
    public Response save(Category category) {
        Category save = categoryRepository.save(category);
        return new Response("Saved!", true, "ID: " + save.getId());
    }

    @Override
    public Response edit(Integer id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty())
            return new Response("Not found!", false);

        categoryRepository.save(category);
        return new Response("Updated!", true);
    }

    @Override
    public Response deleteById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty())
            return new Response("Not found!", false);

        categoryRepository.deleteById(id);
        return new Response("Deleted!", true);
    }
}
