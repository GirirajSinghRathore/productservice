package com.giriraj.productservice.service;

import com.giriraj.productservice.dtos.FakeStoreProductDto;
import com.giriraj.productservice.model.Category;
import com.giriraj.productservice.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("productService")
public class FakeProductServiceImpl implements ProductService{
    private final RestTemplateBuilder restTemplateBuilder;

    public FakeProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String PRODUCT_SERVICE_URL = "https://fakestoreapi.com/products/{id}";
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =restTemplate.getForEntity(PRODUCT_SERVICE_URL, FakeStoreProductDto.class, id);
        Product product = new Product();
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(new Category(fakeStoreProductDto.getCategory()));
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        return product;

    }
}
