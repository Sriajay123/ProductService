package com.example.productdemo.services;

import com.example.productdemo.models.Category;
import com.example.productdemo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{


    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createcategory(String name) {
        Category category=new Category();
        category.setName(name);
        categoryRepository.save(category);

    }

    @Override
    public Category getCategory(int id) {
        return categoryRepository.findById(id).get();
    }
}
