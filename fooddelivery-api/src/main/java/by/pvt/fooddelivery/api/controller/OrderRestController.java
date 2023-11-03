package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;

    @GetMapping("/getAll")
    public List<OrderDTO> getOrders() {
        return orderService.findAllOrders();
    }


    @PostMapping("/addOrder")
    public OrderDTO addOrder(@RequestBody OrderDTO dto) {
        return orderService.addOrder(dto);
    }

    @GetMapping("/getOrder/{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {
        return orderService.findOrderById(id);
    }

    @PutMapping("/updateOrder")
    public OrderDTO updateOrder(@RequestBody OrderDTO dto) {
        return orderService.updateOrder(dto);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
    }

    @PostMapping("/addProduct/{id1}/{id2}")
    public void addProductToOrder(@PathVariable("id1") Long orderId, @PathVariable("id2") Long productId) {
        orderService.addProductToOrder(orderId, productId);
    }
}
