package rk.demo.shop.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rk.demo.shop.model.Product;
import rk.demo.shop.service.ProductService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

}
