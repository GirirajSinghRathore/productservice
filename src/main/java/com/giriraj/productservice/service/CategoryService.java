package com.giriraj.productservice.service;

import com.giriraj.productservice.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(UUID id);
}
