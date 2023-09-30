package com.giriraj.productservice.repository;

import com.giriraj.productservice.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findAll();
    Product getProductById(UUID id);

    boolean existsById(UUID id);
    Product save(Product product);
    void deleteById(UUID id);
}
