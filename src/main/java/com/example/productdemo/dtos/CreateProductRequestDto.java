package com.example.productdemo.dtos;

import com.example.productdemo.models.Category;
import lombok.Data;

@Data
public class CreateProductRequestDto {

    private String name;
    private double price;
    private String category;
}
