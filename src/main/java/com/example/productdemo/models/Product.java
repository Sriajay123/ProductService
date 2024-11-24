package com.example.productdemo.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name;
    private double price;
    @ManyToOne
    private Category category;



}
