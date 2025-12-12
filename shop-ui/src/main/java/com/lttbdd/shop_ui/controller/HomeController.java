package com.lttbdd.shop_ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${app.backend-url}")
    private String backendUrl;

    @GetMapping("/")
    public String home(Model model) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            List<Map<String, Object>> products = restTemplate.getForObject(backendUrl, List.class);

            model.addAttribute("products", products);
            model.addAttribute("userName", "Luân");
            
        } catch (Exception e) {
            model.addAttribute("error", "Không thể kết nối tới Backend Product Service!");
            e.printStackTrace();
        }

        return "home";
    }
}