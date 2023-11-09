package by.pvt.fooddelivery.api.controller;

import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.dto.OrderProductsDTO;
import by.pvt.fooddelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.pvt.fooddelivery.constant.Constant.ADD_PRODUCT_ORDER;
import static by.pvt.fooddelivery.constant.Constant.DELETE_PRODUCT_ORDER;

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
    public OrderDTO addOrder(@RequestBody @Validated OrderDTO dto) {
        return orderService.addOrder(dto);
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

    @PostMapping("product/{quantity}")
    public void addProductToOrder(@PathVariable("quantity") Long quantity, @RequestBody OrderProductsDTO orderProductsDTO) {
        orderService.updateProductOrder(quantity, orderProductsDTO.getOrderDTO().getId(), orderProductsDTO.getProductDTO().getId(), ADD_PRODUCT_ORDER);
    }

    @DeleteMapping("product/{quantity}")
    public void deleteProductToOrder(@PathVariable("quantity") Long quantity, @RequestBody OrderProductsDTO orderProductsDTO) {
        orderService.updateProductOrder(quantity, orderProductsDTO.getOrderDTO().getId(), orderProductsDTO.getProductDTO().getId(), DELETE_PRODUCT_ORDER);
    }
}
