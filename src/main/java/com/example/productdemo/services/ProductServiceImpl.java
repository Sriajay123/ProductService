package com.example.productdemo.services;

import com.example.productdemo.models.Category;
import com.example.productdemo.models.Product;
import com.example.productdemo.repositories.CategoryRepository;
import com.example.productdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createProduct(String name, double price, String category) {

        Product product=new Product();
        Category category1 = categoryRepository.findCategoryByName(category).get();

        product.setCategory(category1);
        product.setName(name);
        product.setPrice(price);

        productRepository.save(product);
    }

    @Override
    public Product getProduct(int id) {
        Product product = productRepository.findById(id).get();



        return product;

    }

    @Override
    public Page<Product> getAllProducts(int pageSize,int pageNumber) {
       return productRepository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by("price").ascending().and(Sort.by("name").ascending())));


    }
}
