package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.dto.OrderProductsDTO;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.pvt.fooddelivery.constant.Constant.*;

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
    public OrderDTO addOrder(@RequestBody String clientLogin) {
        return orderService.addOrder(clientLogin);
    }

    @GetMapping("{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {
        return orderService.findOrderById(id);
    }

    @PutMapping
    public OrderDTO updateOrder(@RequestBody @Validated OrderDTO dto) {
        return orderService.updateOrder(dto);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
    }

    @PostMapping("product")
    public void addProductToOrder(@RequestBody @Validated OrderProductsDTO orderProductsDTO) {
        orderService.updateProductOrder(orderProductsDTO.getQuantityProducts(), orderProductsDTO.getOrderId(), orderProductsDTO.getProductId(), ADD_PRODUCT_ORDER);
    }

    @DeleteMapping("product")
    public void deleteProductToOrder(@RequestBody @Validated OrderProductsDTO orderProductsDTO) {
        orderService.updateProductOrder(orderProductsDTO.getQuantityProducts(), orderProductsDTO.getOrderId(), orderProductsDTO.getProductId(), DELETE_PRODUCT_ORDER);
    }

    @GetMapping("checkout/{id}")
    public OrderDTO checkout(@PathVariable("id") Long id) {
        return orderService.checkout(id);
    }

    @GetMapping("free")
    List<OrderDTO> findOrdersForDelivery() {
        return orderService.findOrdersForDelivery();
    }

    @PostMapping("select")
    OrderDTO selectOrderForDelivery(@RequestBody Long orderId, Long courierId) {
        return orderService.changeOfOrderDeliveryStatus(orderId, courierId, SELECT_ORDER_FOR_DELIVERY);
    }

    @PostMapping("refusal")
    OrderDTO refusalToDeliveryOrder(@RequestBody Long orderId, Long courierId) {
        return orderService.changeOfOrderDeliveryStatus(orderId, courierId, REFUSAL_TO_DELIVERY_ORDER);
    }

    @PostMapping("complete")
    OrderDTO completeTheOrderForDelivery(@RequestBody Long orderId,@RequestBody Long courierId) {
        return orderService.changeOfOrderDeliveryStatus(orderId, courierId, COMPLETE_THE_ORDER_FOR_DELIVERY);
    }
}
