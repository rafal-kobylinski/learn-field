package rk.demo.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rk.demo.shop.model.OrderProduct;
import rk.demo.shop.repository.OrderProductRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderProductServiceImpl implements  OrderProductService {

    private OrderProductRepository orderProductRepository;

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
