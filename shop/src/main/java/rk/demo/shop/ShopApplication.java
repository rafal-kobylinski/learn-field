package rk.demo.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rk.demo.shop.model.Order;
import rk.demo.shop.model.OrderProduct;
import rk.demo.shop.model.OrderStatus;
import rk.demo.shop.model.Product;
import rk.demo.shop.service.OrderProductService;
import rk.demo.shop.service.OrderService;
import rk.demo.shop.service.ProductService;

import java.time.LocalDate;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
    CommandLineRunner runner(ProductService productService, OrderService orderService, OrderProductService orderProductService) {
	    return  args -> {
            productService.save(new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100"));
            productService.save(new Product(2L, "Game Console", 200.00, "http://placehold.it/200x100"));
            productService.save(new Product(3L, "Sofa", 100.00, "http://placehold.it/200x100"));
            productService.save(new Product(4L, "Icecream", 5.00, "http://placehold.it/200x100"));
            productService.save(new Product(5L, "Beer", 3.00, "http://placehold.it/200x100"));
            productService.save(new Product(6L, "Phone", 500.00, "http://placehold.it/200x100"));
            productService.save(new Product(7L, "Watch", 30.00, "http://placehold.it/200x100"));

            Order order = new Order();
            order.setStatus(OrderStatus.PAID.name());
            order.setDateCreated(LocalDate.now());
        };
    }
}
