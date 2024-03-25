package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.OrderLoggerDTO;
import by.pvt.fooddelivery.service.feign.FeignOrderService;
import by.pvt.fooddelivery.service.resttemplate.RestTemplateOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logger/order")
@RequiredArgsConstructor
public class FeignOrderController {

    private final FeignOrderService feignOrderService;

    private final RestTemplateOrderService restTemplateOrderService;

    @GetMapping
    public List<OrderLoggerDTO> getAllOrders() {
        return feignOrderService.getAllOrders();
    }

    @GetMapping("/client/{id}")
    public List<OrderLoggerDTO> getOrdersByClientId(@PathVariable("id") Long clientId) {
        return feignOrderService.getOrdersByClientId(clientId);
    }
}
