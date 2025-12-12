package com.lttbdd.product_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(length = 2000) // Link ảnh dài
    private String image;
    
    private Long price;
    private String owner; // Hãng (Apple, Samsung...)
    
    @Column(columnDefinition = "TEXT") // Mô tả dài
    private String description;
}