package com.lttbdd.order_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // ID của người mua (lấy từ Auth Service)

    private Long totalPrice; // Tổng tiền đơn hàng

    private String customerName;
    private String customerPhone;
    private String customerAddress;

    // Lưu danh sách sản phẩm đã mua dưới dạng chuỗi JSON dài
    // Vì đây là bài tập chuyển đổi nhanh, cách này giúp tránh việc join bảng phức tạp
    @Column(columnDefinition = "TEXT")
    private String productListJson; 

    private LocalDateTime orderDate;

    // Tự động gán ngày giờ khi tạo đơn
    @PrePersist
    protected void onCreate() {
        orderDate = LocalDateTime.now();
    }
}