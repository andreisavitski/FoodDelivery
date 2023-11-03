package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.mapper.OrderMapper;
import by.pvt.fooddelivery.repository.OrderRepository;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderDTO addOrder(OrderDTO orderDTO) {
        return orderMapper.toDTO(orderRepository.save(orderMapper.toOrder(orderDTO)));
    }

    @Override
    @Transactional
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderDTO findOrderById(Long orderId) {
        return orderMapper.toDTO(orderRepository.findById(orderId).orElseThrow(
                () -> new RuntimeException("Order does not exist")));
    }

    @Override
    public List<OrderDTO> findAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDTO).toList();
    }

    @Override
    @Transactional
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        return orderMapper.toDTO(orderRepository.save(orderMapper.toOrder(orderDTO)));
    }

    @Override
    @Transactional
    public void addProductToOrder(Long orderId, Long productId) {
        List<Product> orderProducts = orderRepository.findProductById(orderId);
        orderProducts.add(productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException("There is no product with this id")));
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new RuntimeException("There is no order with this id"));
        order.setProducts(orderProducts);
        order.setTotalCost(calculationTotalCost(orderProducts));
        orderRepository.save(order);
    }

    private BigDecimal calculationTotalCost(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
