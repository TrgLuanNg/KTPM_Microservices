package com.lttbdd.shop_ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Nhớ import dòng này
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${app.backend-url}")
    private String backendUrl;

    // --- Trang chủ ---
    @GetMapping("/")
    public String home(Model model) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            // Gọi backend lấy danh sách sản phẩm
            List<Map<String, Object>> products = restTemplate.getForObject(backendUrl, List.class);

            model.addAttribute("products", products);
            model.addAttribute("userName", "Luân");
            
        } catch (Exception e) {
            model.addAttribute("error", "Không thể kết nối tới Backend Product Service!");
            e.printStackTrace();
        }

        return "home";
    }

    // --- Trang chi tiết sản phẩm (MỚI) ---
    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            // Gọi API lấy 1 sản phẩm: /api/products/{id}
            String url = backendUrl + "/" + id;
            Map product = restTemplate.getForObject(url, Map.class);
            
            model.addAttribute("product", product);
        } catch (Exception e) {
            model.addAttribute("error", "Không tìm thấy sản phẩm!");
        }
        return "detail"; // Trả về file detail.html
    }

    @GetMapping("/cart")
    public String viewCart() {
        return "cart"; // Trả về file cart.html
    }

}