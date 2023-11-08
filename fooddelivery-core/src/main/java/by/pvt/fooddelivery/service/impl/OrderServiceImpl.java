package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Order;
import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.exception.ApplicationException;
import by.pvt.fooddelivery.mapper.OrderMapper;
import by.pvt.fooddelivery.repository.OrderRepository;
import by.pvt.fooddelivery.repository.ProductRepository;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static by.pvt.fooddelivery.exception.ApplicationError.ORDER_NOT_FOUND;
import static by.pvt.fooddelivery.exception.ApplicationError.PRODUCT_NOT_FOUND;

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
        orderRepository.delete(orderMapper.toOrder(findOrderById(orderId)));
    }

    @Override
    public OrderDTO findOrderById(Long orderId) {
        return orderMapper.toDTO(orderRepository.findById(orderId).orElseThrow(() -> new ApplicationException(ORDER_NOT_FOUND)));
    }

    @Override
    public List<OrderDTO> findAllOrders() {
        List<OrderDTO> orders = orderRepository.findAll().stream().map(orderMapper::toDTO).toList();
        if (orders.isEmpty()) {
            throw new ApplicationException(ORDER_NOT_FOUND);
        }
        return orders;
    }

    @Override
    @Transactional
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        return orderMapper.toDTO(orderRepository.save(orderMapper.toOrder(orderDTO)));
    }

    @Override
    @Transactional
    public void addProductToOrder(Long orderId, Long productId) {
        Order order = orderMapper.toOrder(findOrderById(orderId));
        List<Product> orderProducts = order.getProducts();
        orderProducts.add(productRepository.findById(productId).orElseThrow(() -> new ApplicationException(PRODUCT_NOT_FOUND)));
        order.setProducts(orderProducts);
        order.setTotalCost(calculationTotalCost(orderProducts));
        orderRepository.save(order);
    }

    private BigDecimal calculationTotalCost(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
