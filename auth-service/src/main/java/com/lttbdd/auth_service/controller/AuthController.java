package com.lttbdd.auth_service.controller;

import com.lttbdd.auth_service.entity.User;
import com.lttbdd.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // API Đăng ký
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUser) {
        // 1. Kiểm tra email đã tồn tại chưa
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email này đã được sử dụng!");
        }
        
        // 2. Lưu user mới
        User savedUser = userRepository.save(newUser);
        return ResponseEntity.ok(savedUser);
    }

    // API Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        // 1. Tìm user trong DB
        User user = userRepository.findByEmailAndPassword(email, password);

        if (user != null) {
            return ResponseEntity.ok(user); // Trả về thông tin user nếu đúng
        } else {
            // Trả về lỗi 401 nếu sai
            Map<String, String> error = new HashMap<>();
            error.put("message", "Sai email hoặc mật khẩu");
            return ResponseEntity.status(401).body(error);
        }
    }
}