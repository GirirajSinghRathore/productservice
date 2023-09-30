//package com.giriraj.productservice.service;
//
//import com.giriraj.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductDto;
//import com.giriraj.productservice.dtos.GenericProductDto;
//import com.giriraj.productservice.exception.ProductNotFoundException;
//import com.giriraj.productservice.model.Category;
//import com.giriraj.productservice.model.Product;
//import com.giriraj.productservice.thirdpartyclient.productservice.fakestore.FakeStoreProductServiceClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
//@Service("fakestoreproductService")
//public class FakeProductServiceImpl implements ProductService{
//    @Autowired
//    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
////    @Override
//    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
//        return fakeStoreProductDtoToGenericProductDto(fakeStoreProductServiceClient.getProductById(id));
//    }
//
//    @Override
//    public GenericProductDto getProductById(UUID id) throws ProductNotFoundException {
//        return null;
//    }
//
//    @Override
//    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
//        return fakeStoreProductDtoToGenericProductDto(fakeStoreProductServiceClient.createProduct(genericProductDto));
//    }
//
//    @Override
//    public void updateProduct(GenericProductDto genericProductDto) {
//        fakeStoreProductServiceClient.updateProduct(genericProductDto);
//    }
//
//    @Override
//    public void deleteProductById(UUID id) {
//
//    }
//
////    @Override
//    public void deleteProductById(Long id) {
//        fakeStoreProductServiceClient.deleteProductById(id);
//    }
//
//    @Override
//    public List<GenericProductDto> getAllProducts() {
//        List<FakeStoreProductDto> fakeStoreProductDtoList = fakeStoreProductServiceClient.getAllProducts();
//        return fakeStoreProductDtoList.stream().map(this::fakeStoreProductDtoToGenericProductDto).toList();
//    }
//    private GenericProductDto fakeStoreProductDtoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
//        GenericProductDto genericProductDto = new GenericProductDto();
//        genericProductDto.setId(fakeStoreProductDto.getId());
//        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
//        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
//        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
//        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
//        genericProductDto.setImage(fakeStoreProductDto.getImage());
//        return genericProductDto;
//    }
//}
