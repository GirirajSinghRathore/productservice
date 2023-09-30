package com.giriraj.productservice.repository;

import com.giriraj.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findAll();
    Product getProductById(UUID id);

    boolean existsById(UUID id);
    Product save(Product product);
    Product deleteProductById(UUID id);
}
