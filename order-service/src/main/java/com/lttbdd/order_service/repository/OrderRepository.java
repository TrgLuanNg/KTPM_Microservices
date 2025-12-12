package com.lttbdd.order_service.repository;

import com.lttbdd.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Tìm lịch sử mua hàng của một user
    List<Order> findByUserId(Long userId);
}