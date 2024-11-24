package com.example.productdemo.repositories;

import com.example.productdemo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {


    Optional<Category> findCategoryByName(String name);
    Optional<Category> findCategoryById(int id);
}
