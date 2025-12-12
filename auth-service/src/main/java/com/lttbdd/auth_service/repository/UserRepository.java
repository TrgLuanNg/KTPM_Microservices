package com.lttbdd.auth_service.repository;

import com.lttbdd.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Tìm user theo email để kiểm tra trùng lặp
    User findByEmail(String email);

    // Tìm user để đăng nhập
    User findByEmailAndPassword(String email, String password);
}