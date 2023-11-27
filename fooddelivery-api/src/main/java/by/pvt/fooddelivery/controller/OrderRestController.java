package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.dto.OrderDeliveryUpdaterDTO;
import by.pvt.fooddelivery.dto.OrderProductChangerDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.pvt.fooddelivery.constant.AppConstants.*;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;

    @MethodLogging
    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.findAllOrders();
    }

    @MethodLogging
    @PostMapping
    public OrderDTO addOrder(@RequestBody String clientLogin) {
        return orderService.addOrder(clientLogin);
    }

    @MethodLogging
    @GetMapping("{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {
        return orderService.findOrderById(id);
    }

    @MethodLogging
    @PutMapping
    public OrderDTO updateOrder(@RequestBody @Validated OrderDTO dto) {
        return orderService.updateOrder(dto);
    }


    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
    }


    @PostMapping("product")
    public void addProductToOrder(@RequestBody OrderProductChangerDTO dto) {
        orderService.updateProductOrder(dto.getQuantityProducts(), dto.getOrderId(), dto.getProductId(), ADD_PRODUCT_ORDER);
    }


    @DeleteMapping("product")
    public void deleteProductToOrder(@RequestBody OrderProductChangerDTO dto) {
        orderService.updateProductOrder(dto.getQuantityProducts(), dto.getOrderId(), dto.getProductId(), DELETE_PRODUCT_ORDER);
    }

    @MethodLogging
    @GetMapping("checkout/{id}")
    public OrderDTO checkout(@PathVariable("id") Long id) {
        return orderService.checkout(id);
    }

    @MethodLogging
    @GetMapping("free")
    List<OrderDTO> findOrdersForDelivery() {
        return orderService.findOrdersForDelivery();
    }

    //    @MethodLogging
    @PostMapping("select")
    OrderDTO selectOrderForDelivery(@RequestBody OrderDeliveryUpdaterDTO dto) {
        return orderService.changeOfOrderDeliveryStatus(dto.getOrderId(), dto.getOrderId(), SELECT_ORDER_FOR_DELIVERY);
    }

    @MethodLogging
    @PostMapping("refusal")
    OrderDTO refusalToDeliveryOrder(@RequestBody OrderDeliveryUpdaterDTO dto) {
        return orderService.changeOfOrderDeliveryStatus(dto.getOrderId(), dto.getOrderId(), REFUSAL_TO_DELIVERY_ORDER);
    }

    @MethodLogging
    @PostMapping("complete")
    OrderDTO completeTheOrderForDelivery(@RequestBody OrderDeliveryUpdaterDTO dto) {
        return orderService.changeOfOrderDeliveryStatus(dto.getOrderId(), dto.getOrderId(), COMPLETE_THE_ORDER_FOR_DELIVERY);
    }
}
