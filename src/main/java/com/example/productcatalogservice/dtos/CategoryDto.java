package com.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private List<ProductDto> products;
}
