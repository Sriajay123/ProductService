package com.example.productdemo.services;

import com.example.productdemo.models.Category;
import com.example.productdemo.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public void  createProduct(String name, double price, String category);
    public Product getProduct(int id);
    public Page<Product> getAllProducts(int pageSize,int pageNumber);
}
