package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.findAllOrders();
    }

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO dto) {
        return orderService.addOrder(dto);
    }

    @GetMapping("{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {
        return orderService.findOrderById(id);
    }

    @PutMapping
    public OrderDTO updateOrder(@RequestBody OrderDTO dto) {
        return orderService.updateOrder(dto);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
    }

    @PostMapping("{id1}/{id2}")
    public void addProductToOrder(@PathVariable("id1") Long orderId, @PathVariable("id2") Long productId) {
        orderService.addProductToOrder(orderId, productId);
    }
}
