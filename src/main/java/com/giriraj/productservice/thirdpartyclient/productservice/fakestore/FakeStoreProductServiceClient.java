package com.giriraj.productservice.thirdpartyclient.productservice.fakestore;

import com.giriraj.productservice.dtos.GenericProductDto;
import com.giriraj.productservice.exception.ProductNotFoundException;
import com.giriraj.productservice.model.Category;
import com.giriraj.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class FakeStoreProductServiceClient {
    @Autowired
    private  RestTemplateBuilder restTemplateBuilder;

    @Value("${product-service.url}")
    private String productServiceUrl;

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String PRODUCT_SERVICE_URL = productServiceUrl;
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =restTemplate.getForEntity(PRODUCT_SERVICE_URL, FakeStoreProductDto.class, id);
        Product product = new Product();
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product not found with id: "+id+" in FakeStore");
        }
        return fakeStoreProductDto;

    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = genericProductDtoToFakeStoreProductDto(genericProductDto);
        RestTemplate restTemplate = restTemplateBuilder.build();
        String CREATE_PRODUCT_SERVICE_URL = "https://fakestoreapi.com/products";
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.postForEntity(CREATE_PRODUCT_SERVICE_URL, fakeStoreProductDto, FakeStoreProductDto.class);
        return fakeStoreProductDtoResponseEntity.getBody();
    }
    private FakeStoreProductDto genericProductDtoToFakeStoreProductDto(GenericProductDto genericProductDto){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(genericProductDto.getId());
        fakeStoreProductDto.setTitle(genericProductDto.getTitle());
        fakeStoreProductDto.setPrice(genericProductDto.getPrice());
        fakeStoreProductDto.setDescription(genericProductDto.getDescription());
        fakeStoreProductDto.setCategory(genericProductDto.getCategory());
        fakeStoreProductDto.setImage(genericProductDto.getImage());
        return fakeStoreProductDto;
    }
    public void updateProduct(GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = genericProductDtoToFakeStoreProductDto(genericProductDto);

        RestTemplate restTemplate = restTemplateBuilder.build();
        String UPDATE_PRODUCT_SERVICE_URL = "https://fakestoreapi.com/products/{id}";
        restTemplate.put(UPDATE_PRODUCT_SERVICE_URL, fakeStoreProductDto, fakeStoreProductDto.getId());

    }

    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String DELETE_PRODUCT_SERVICE_URL = "https://fakestoreapi.com/products/{id}";
        restTemplate.delete(DELETE_PRODUCT_SERVICE_URL, id);
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String GET_ALL_PRODUCTS_SERVICE_URL = "https://fakestoreapi.com/products";
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity(GET_ALL_PRODUCTS_SERVICE_URL, FakeStoreProductDto[].class);
        return Arrays.asList(Objects.requireNonNull(fakeStoreProductDtoResponseEntity.getBody()));
    }
}
