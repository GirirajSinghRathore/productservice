package com.giriraj.productservice.service;

import com.giriraj.productservice.dtos.GenericProductDto;
import com.giriraj.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    void updateProduct(GenericProductDto genericProductDto);
    void deleteProductById(Long id);
    List<GenericProductDto> getAllProducts();

}
