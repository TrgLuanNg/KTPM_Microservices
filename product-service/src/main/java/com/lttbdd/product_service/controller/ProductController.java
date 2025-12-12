package com.lttbdd.product_service.controller;

import com.lttbdd.product_service.entity.Product;
import com.lttbdd.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    // API tạo mới (để test)
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }
}