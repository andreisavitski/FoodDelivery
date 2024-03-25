package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(String clientLogin);

    void deleteOrderById(Long orderId);

    OrderDTO findOrderById(Long orderId);

    List<OrderDTO> findAllOrders();
    List<OrderDTO> findOrdersByClientId(Long id);

    OrderDTO updateOrder(OrderDTO orderDTO);

    void updateProductOrder(Long orderId, Long productId, String condition);

    OrderDTO checkout(Long orderId);

    List<OrderDTO> findOrdersForDelivery();

    OrderDTO changeOfOrderDeliveryStatus(Long orderId, Long courierId, String condition);
}
