package com.lttbdd.auth_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // Bảng tên là 'users'
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true) // Email không được trùng nhau
    private String email;

    private String password;
}