package com.giriraj.productservice.service;

import com.giriraj.productservice.dtos.FakeStoreProductDto;
import com.giriraj.productservice.dtos.GenericProductDto;
import com.giriraj.productservice.exception.ProductNotFoundException;
import com.giriraj.productservice.model.Category;
import com.giriraj.productservice.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service("productService")
public class FakeProductServiceImpl implements ProductService{
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String PRODUCT_SERVICE_URL = "https://fakestoreapi.com/products/{id}";
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =restTemplate.getForEntity(PRODUCT_SERVICE_URL, FakeStoreProductDto.class, id);
        Product product = new Product();
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product not found with id: "+id+" in FakeStore");
        }
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(new Category(fakeStoreProductDto.getCategory()));
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        return product;

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String CREATE_PRODUCT_SERVICE_URL = "https://fakestoreapi.com/products";
        ResponseEntity<GenericProductDto> genericProductDtoResponseEntity = restTemplate.postForEntity(CREATE_PRODUCT_SERVICE_URL, genericProductDto, GenericProductDto.class);
        return genericProductDtoResponseEntity.getBody();
    }

    @Override
    public void updateProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String UPDATE_PRODUCT_SERVICE_URL = "https://fakestoreapi.com/products/{id}";
        restTemplate.put(UPDATE_PRODUCT_SERVICE_URL, genericProductDto, genericProductDto.getId());

    }

    @Override
    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String DELETE_PRODUCT_SERVICE_URL = "https://fakestoreapi.com/products/{id}";
        restTemplate.delete(DELETE_PRODUCT_SERVICE_URL, id);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String GET_ALL_PRODUCTS_SERVICE_URL = "https://fakestoreapi.com/products";
        ResponseEntity<GenericProductDto[]> genericProductDtoResponseEntity1 = restTemplate.getForEntity(GET_ALL_PRODUCTS_SERVICE_URL, GenericProductDto[].class);
        ResponseEntity<List> genericProductDtoResponseEntity = restTemplate.getForEntity(GET_ALL_PRODUCTS_SERVICE_URL, List.class);
//        return genericProductDtoResponseEntity.getBody();
        return Arrays.asList(genericProductDtoResponseEntity1.getBody());
    }
}
