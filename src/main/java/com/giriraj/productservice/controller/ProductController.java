package com.giriraj.productservice.controller;

import com.giriraj.productservice.dtos.ExceptionHandlerDto;
import com.giriraj.productservice.dtos.GenericProductDto;
import com.giriraj.productservice.exception.ProductNotFoundException;
import com.giriraj.productservice.model.Product;
import com.giriraj.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<GenericProductDto>> getAllProducts(){
        List<GenericProductDto> genericProductDtoList =
                productService.getAllProducts();
        return new ResponseEntity<>(genericProductDtoList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<GenericProductDto> getProuctById(@PathVariable("id") Long id) throws ProductNotFoundException {
        GenericProductDto product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductbyId(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<GenericProductDto> createProduct(@RequestBody GenericProductDto genericProductDto){
        return new ResponseEntity<>(productService.createProduct(genericProductDto), HttpStatus.CREATED);

    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateProduct(@RequestBody GenericProductDto genericProductDto,@PathVariable("id") Long id){
        genericProductDto.setId(id);
        productService.updateProduct(genericProductDto);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

}
