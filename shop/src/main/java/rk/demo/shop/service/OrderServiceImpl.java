package rk.demo.shop.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import rk.demo.shop.model.Order;
import rk.demo.shop.repository.OrderRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
@Data
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    OrderRepository orderRepository;

    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        return orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

}
