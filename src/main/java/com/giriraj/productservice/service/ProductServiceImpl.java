package com.giriraj.productservice.service;

import com.giriraj.productservice.dtos.GenericProductDto;
import com.giriraj.productservice.exception.ProductNotFoundException;
import com.giriraj.productservice.model.Price;
import com.giriraj.productservice.model.Product;
import com.giriraj.productservice.repository.ProductRepository;
import com.giriraj.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public GenericProductDto getProductById(UUID id) throws ProductNotFoundException {

        return productToGenericProductDto(productRepository.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return productToGenericProductDto(productRepository.save(genericProductDtoToProduct(genericProductDto)));
    }

    @Override
    public void updateProduct(GenericProductDto genericProductDto) {

    }

    @Override
    public void deleteProductById(UUID id) {

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }
    private GenericProductDto productToGenericProductDto(Product product){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(product.getId());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setPrice(product.getPrice());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setCategory(product.getCategory());
        genericProductDto.setImage(product.getImage());
        return genericProductDto;
    }
    private Product genericProductDtoToProduct(GenericProductDto genericProductDto){
        Product product = new Product();
        product.setId(genericProductDto.getId());
        product.setTitle(genericProductDto.getTitle());
        product.setPrice(genericProductDto.getPrice());
        product.setDescription(genericProductDto.getDescription());
        product.setCategory(genericProductDto.getCategory());
        product.setImage(genericProductDto.getImage());
        return product;
    }
}
