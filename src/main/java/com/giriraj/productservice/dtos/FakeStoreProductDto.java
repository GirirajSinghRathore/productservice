package com.giriraj.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
//    {
//        id:1,
//                title:'...',
//            price:'...',
//            category:'...',
//            description:'...',
//            image:'...'
//    }
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
