package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(OrderDTO orderDTO);

    void deleteOrderById(Long orderId);

    OrderDTO findOrderById(Long orderId);

    List<OrderDTO> findAllOrders();

    OrderDTO updateOrder(OrderDTO orderDTO);

    void addProductToOrder(Long orderId, Long productId);
}
