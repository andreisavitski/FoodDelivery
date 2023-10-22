package by.pvt.fooddelivery.service.impl;

import by.pvt.fooddelivery.domain.Product;
import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.dto.ProductDTO;
import by.pvt.fooddelivery.mapper.OrderMapper;
import by.pvt.fooddelivery.mapper.ProductMapper;
import by.pvt.fooddelivery.repository.OrderRepository;
import by.pvt.fooddelivery.service.OrderApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderApi {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;

    @Override
    public void addOrder(OrderDTO orderDTO) {
        orderRepository.save(orderMapper.toOrder(orderDTO));
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        return orderMapper.toDTO(orderRepository.getOrderById(orderId).orElseThrow(
                () -> new RuntimeException("Order does not exist")));
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders().stream().map(orderMapper::toDTO).toList();
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteOrderById(orderId);
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
        orderRepository.updateOrder(orderMapper.toOrder(orderDTO));
    }

    @Override
    public void addProductToOrder(Long orderId, ProductDTO productDTO) {
        List<Product> orderProducts = orderRepository.getOrderProducts(orderId);
        orderProducts.add(productMapper.toProduct(productDTO));
        orderRepository.updateListProducts(orderId, orderProducts);
        List<Product> orderProductsAfterUpdate = orderRepository.getOrderProducts(orderId);
        orderRepository.updateTotalCost(orderId, calculationTotalCost(orderProductsAfterUpdate));
    }

    private BigDecimal calculationTotalCost(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
