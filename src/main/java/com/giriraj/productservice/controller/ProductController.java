package com.giriraj.productservice.controller;

import com.giriraj.productservice.model.Product;
import com.giriraj.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Value("${product-service.type}")
    private String productServiceType;
    private ProductService productService;
    public ProductController(@Qualifier("productService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public void getAllProducts(){

    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProuctById(@PathVariable("id") Long id){
    return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public void deleteProductbyId(){

    }
    @PostMapping
    public void createProduct(){

    }
    @PutMapping
    public void updateProduct(){

    }

}
