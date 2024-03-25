package by.pvt.fooddelivery.service.feign;

import by.pvt.fooddelivery.dto.OrderLoggerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("fooddelivery-order-logger")
public interface FeignOrderService {
    @GetMapping("order-logger/api/v1/order")
    List<OrderLoggerDTO> getAllOrders();

    @GetMapping("order-logger/api/v1/order/client/{id}")
    List<OrderLoggerDTO> getOrdersByClientId(@PathVariable("id") Long clientId);
}
