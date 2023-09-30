package com.giriraj.productservice.dtos;

import com.giriraj.productservice.model.Category;
import com.giriraj.productservice.model.Price;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class GenericProductDto {
    private UUID id;
    private String title;
    private Price price;
    private Category category;
    private String description;
    private String image;



}
