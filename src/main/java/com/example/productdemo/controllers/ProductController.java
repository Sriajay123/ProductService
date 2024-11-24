package com.example.productdemo.controllers;

import com.example.productdemo.dtos.CreateProductRequestDto;
import com.example.productdemo.dtos.ProductResponseDto;
import com.example.productdemo.models.Product;
import com.example.productdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable ("id") int id){
       ProductResponseDto responseDto=new ProductResponseDto();
        Product product = productService.getProduct(id);
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setCategory(product.getCategory());
        responseDto.setPrice(product.getPrice());
        return new ResponseEntity<>(responseDto, HttpStatusCode.valueOf(200));
    }


     @GetMapping("/all")
    public ResponseEntity<Page<Product>> getAll(@RequestParam(value="pageSize",defaultValue = "20") int pageSize,
                                                @RequestParam(value="pageNumber",defaultValue = "1") int pageNumber){
       /* List<Product> allProducts = productService.getAllProducts();
        List<ProductResponseDto> responseDtos=new ArrayList<>();
        for(Product p:allProducts){
            ProductResponseDto responseDto=new ProductResponseDto();
            responseDto.setId(p.getId());
            responseDto.setName(p.getName());
            responseDto.setPrice(p.getPrice());
            responseDto.setCategory(p.getCategory());
            responseDtos.add(responseDto);
        }
        return new ResponseEntity<>(responseDtos,HttpStatusCode.valueOf(200));*/
         Page<Product> allProducts = productService.getAllProducts(pageSize,pageNumber);


         return new ResponseEntity<>(allProducts,HttpStatusCode.valueOf(200));

     }

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateProductRequestDto requestDto){

        productService.createProduct(requestDto.getName(), requestDto.getPrice(), requestDto.getCategory());
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }


}
