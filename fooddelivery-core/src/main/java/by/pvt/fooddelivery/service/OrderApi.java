package by.pvt.fooddelivery.service;

import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.dto.ProductDTO;

import java.util.List;

public interface OrderApi {
    void addOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long orderId);

    List<OrderDTO> getAllOrders();

    void deleteOrderById(Long orderId);

    void updateOrder(OrderDTO orderDTO);
    void addProductToOrder(Long orderId, ProductDTO productDTO);
}
