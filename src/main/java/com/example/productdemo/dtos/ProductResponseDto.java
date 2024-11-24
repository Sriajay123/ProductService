package com.example.productdemo.dtos;

import com.example.productdemo.models.Category;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductResponseDto
{

    private int id ;
    private String name;
    private double price;
    private Category category;

}
