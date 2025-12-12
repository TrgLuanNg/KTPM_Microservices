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
    
    @Column(length = 2000)
    private String image;
    
    private Long price;
    private String owner; // Hãng
    
    @Column(columnDefinition = "TEXT")
    private String description;

    // --- THÊM DÒNG NÀY ---
    private Integer quantity; // Số lượng tồn kho
}