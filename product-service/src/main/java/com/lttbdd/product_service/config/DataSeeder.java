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
            // Kiểm tra nếu chưa có dữ liệu thì mới nạp
            if (repo.count() == 0) {
                repo.saveAll(Arrays.asList(
                    // Cấu trúc: id, name, image, price, owner, description, QUANTITY
                    new Product(null, "iPhone 14 Pro Max", "https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/09/08/44444.png", 27990000L, "Apple", "Màn hình Dynamic Island, Chip A16 Bionic siêu mạnh.", 10),
                    new Product(null, "Samsung Galaxy Z Fold4", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/a/samsung_galaxy_z_fold_4-7_3.jpg", 29990000L, "Samsung", "Màn hình gập đỉnh cao, đa nhiệm tuyệt vời.", 5),
                    new Product(null, "Samsung Galaxy S23 Ultra", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/2/s23-ultra-xanh_4.png", 21990000L, "Samsung", "Camera mắt thần bóng đêm 200MP.", 8),
                    new Product(null, "OPPO Find N2 Flip", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/n/2/n2_flip_-_combo_product_-_black.png", 19990000L, "Oppo", "Gập vỏ sò thời thượng, nếp gấp tàng hình.", 3),
                    new Product(null, "Xiaomi 13 Pro", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/x/i/xiaomi-13-pro-thumb-1-600x600.jpg", 18490000L, "Xiaomi", "Camera Leica chuyên nghiệp, sạc siêu nhanh.", 15),
                    new Product(null, "iPhone 13", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/4/14_1_9_2_9.jpg", 15990000L, "Apple", "Thiết kế vuông vức, hiệu năng vẫn rất mạnh.", 20),
                    new Product(null, "iPad Pro M2 11 inch", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/i/p/ipad-pro-11-2022-wifi-trang-600x600_1.jpg", 20590000L, "Apple", "Chip M2 xử lý đồ họa đỉnh cao.", 7),
                    new Product(null, "MacBook Air M1", "https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/m/a/macbook-air-m1-2020-gray-600x600.jpg", 18990000L, "Apple", "Laptop mỏng nhẹ, pin trâu nhất phân khúc.", 12)
                ));
                System.out.println(">>> ĐÃ NẠP DỮ LIỆU SẢN PHẨM & KHO HÀNG THÀNH CÔNG");
            }
        };
    }
}