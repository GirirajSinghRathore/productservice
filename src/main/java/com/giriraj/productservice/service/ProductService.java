package com.giriraj.productservice.service;

import com.giriraj.productservice.dtos.GenericProductDto;
import com.giriraj.productservice.exception.ProductNotFoundException;
import com.giriraj.productservice.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    GenericProductDto getProductById(UUID id) throws ProductNotFoundException;
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    void updateProduct(GenericProductDto genericProductDto);
    void deleteProductById(UUID id);
    List<GenericProductDto> getAllProducts();

}
