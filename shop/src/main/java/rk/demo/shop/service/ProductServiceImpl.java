package rk.demo.shop.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rk.demo.shop.exception.ResourceNotFoundException;
import rk.demo.shop.model.Product;
import rk.demo.shop.repository.ProductRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository repository;

    @Override
    public Iterable<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save (Product product) {
        return repository.save(product);
    }
}
