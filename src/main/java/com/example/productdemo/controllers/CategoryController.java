package com.example.productdemo.controllers;


import com.example.productdemo.dtos.CategoryResponseDto;
import com.example.productdemo.dtos.CreateCategoryRequestDto;
import com.example.productdemo.models.Category;
import com.example.productdemo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cat")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/c")
    public ResponseEntity<Category> create(@RequestBody CreateCategoryRequestDto requestDto){

        categoryService.createcategory(requestDto.getName());
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));

    }

     @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable("id") int id ){
        CategoryResponseDto responseDto=new CategoryResponseDto();
        Category category = categoryService.getCategory(id);
        responseDto.setId(category.getId());
        responseDto.setName(category.getName());
        return new ResponseEntity<>(responseDto,HttpStatusCode.valueOf(200));

    }
}
