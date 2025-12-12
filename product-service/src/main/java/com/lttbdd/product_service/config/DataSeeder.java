package com.lttbdd.product_service.config;

import com.lttbdd.product_service.entity.Product;
import com.lttbdd.product_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
public class DataSeeder {
    @Bean
    public CommandLineRunner initData(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.saveAll(Arrays.asList(
                    new Product(null, "IPhone 14 Pro Max (1TB)", "https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/09/08/44444.png", 40890000L, "Apple", "Màn hình Dynamic Island..."),
                    new Product(null, "Samsung Galaxy Z Fold4", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/a/samsung_galaxy_z_fold_4-7_3.jpg", 31990000L, "Samsung", "Camera mắt thần..."),
                    new Product(null, "Samsung Galaxy S23 Ultra", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/2/s23-ultra-xanh_4.png", 35990000L, "Samsung", "Chip Snapdragon 8 Gen 2..."),
                    new Product(null, "OPPO Find N2 Flip", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/n/2/n2_flip_-_combo_product_-_black.png", 19990000L, "Oppo", "Gập vỏ sò...")
                ));
                System.out.println(">>> ĐÃ NẠP DỮ LIỆU ĐIỆN THOẠI THÀNH CÔNG");
            }
        };
    }
}