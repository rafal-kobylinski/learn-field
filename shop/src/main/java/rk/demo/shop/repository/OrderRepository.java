package rk.demo.shop.repository;

import org.springframework.data.repository.CrudRepository;
import rk.demo.shop.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
