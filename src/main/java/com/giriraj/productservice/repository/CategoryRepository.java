package com.giriraj.productservice.repository;

import com.giriraj.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    List<Category> findAll();
    Category getCategoryById(UUID id);
}
