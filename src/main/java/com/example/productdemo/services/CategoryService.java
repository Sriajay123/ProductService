package com.example.productdemo.services;

import com.example.productdemo.models.Category;

public interface CategoryService {

    void createcategory(String name);
    Category getCategory(int id);

}
