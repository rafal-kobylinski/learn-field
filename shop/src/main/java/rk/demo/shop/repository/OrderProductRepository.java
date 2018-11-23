package rk.demo.shop.repository;

import org.springframework.data.repository.CrudRepository;
import rk.demo.shop.model.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
}
