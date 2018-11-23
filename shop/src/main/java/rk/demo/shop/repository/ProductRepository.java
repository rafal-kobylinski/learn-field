package rk.demo.shop.repository;

import org.springframework.data.repository.CrudRepository;
import rk.demo.shop.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
