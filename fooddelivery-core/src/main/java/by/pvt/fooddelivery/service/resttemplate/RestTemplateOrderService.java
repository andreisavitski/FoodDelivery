package by.pvt.fooddelivery.service.resttemplate;

import by.pvt.fooddelivery.dto.OrderLoggerDTO;

import java.util.List;

public interface RestTemplateOrderService {
    List<OrderLoggerDTO> getAllOrders();

    List<OrderLoggerDTO> getOrdersByClientId(Long clientId);
}
