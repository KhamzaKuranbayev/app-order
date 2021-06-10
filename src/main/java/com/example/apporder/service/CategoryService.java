package com.example.apporder.service;

import com.example.apporder.dto.res.Response;
import com.example.apporder.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAll();

    Category findOneByProductId(Integer productId);

    Response findById(Integer id);

    Response save(Category category);

    Response edit(Integer id, Category category);

    Response deleteById(Integer id);
}
