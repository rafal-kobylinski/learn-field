package rk.demo.shop.dto;

import lombok.Data;
import rk.demo.shop.model.Product;

@Data
public class OrderProductDto {

    private Product product;
    private Integer quantity;
}
