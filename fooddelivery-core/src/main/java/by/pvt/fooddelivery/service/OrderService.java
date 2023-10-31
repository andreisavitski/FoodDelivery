package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void addOrder(OrderDTO orderDTO);

    void deleteOrderById(Long orderId);

    OrderDTO findOrderById(Long orderId);

    List<OrderDTO> findAllOrders();

    void updateOrder(OrderDTO orderDTO);

    void addProductToOrder(Long orderId, Long productId);
}
