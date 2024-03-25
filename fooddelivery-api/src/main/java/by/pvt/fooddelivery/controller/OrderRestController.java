package by.pvt.fooddelivery.controller;

import by.pvt.fooddelivery.dto.OrderDTO;
import by.pvt.fooddelivery.dto.OrderDeliveryUpdaterDTO;
import by.pvt.fooddelivery.dto.OrderProductChangerDTO;
import by.pvt.fooddelivery.logging.MethodLogging;
import by.pvt.fooddelivery.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.pvt.fooddelivery.constant.AppConstants.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Tag(name = "ORDER", description = "Allows you to manage orders")
public class OrderRestController {

    private final OrderService orderService;

    @Operation(summary = "Getting all orders", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping
    public List<OrderDTO> getOrders() {
        return orderService.findAllOrders();
    }

    @Operation(summary = "Getting orders by client ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/client/{id}")
    public List<OrderDTO> getOrdersByClientId(@PathVariable("id") Long id) {
        return orderService.findOrdersByClientId(id);
    }

    @Operation(summary = "Create an order", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping
    public OrderDTO addOrder(@RequestBody String clientLogin) {
        return orderService.addOrder(clientLogin);
    }

    @Operation(summary = "Getting an order by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {
        return orderService.findOrderById(id);
    }

    @Operation(summary = "Changing order", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PutMapping
    public OrderDTO updateOrder(@RequestBody @Validated OrderDTO dto) {
        return orderService.updateOrder(dto);
    }

    @Operation(summary = "Deleting an order by ID", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
    }

    @Operation(summary = "Add product to order", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/product")
    public void addProductToOrder(@RequestBody OrderProductChangerDTO dto) {
        orderService.updateProductOrder(dto.getOrderId(), dto.getProductId(), ADD_PRODUCT_ORDER);
    }

    @Operation(summary = "Remove product from order", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping("/product")
    public void removeProductFromOrder(@RequestBody OrderProductChangerDTO dto) {
        orderService.updateProductOrder(dto.getOrderId(), dto.getProductId(), DELETE_PRODUCT_ORDER);
    }

    @Operation(summary = "Placing an order", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/checkout/{id}")
    public OrderDTO checkout(@PathVariable("id") Long id) {
        return orderService.checkout(id);
    }

    @Operation(summary = "Search for available orders", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @GetMapping("/free")
    List<OrderDTO> findOrdersForDelivery() {
        return orderService.findOrdersForDelivery();
    }

    @Operation(summary = "Order fulfillment by courier", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/select")
    OrderDTO selectOrderForDelivery(@RequestBody OrderDeliveryUpdaterDTO dto) {
        return orderService.changeOfOrderDeliveryStatus(dto.getOrderId(), dto.getCourierId(), SELECT_ORDER_FOR_DELIVERY);
    }

    @Operation(summary = "Cancellation of an order", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/refusal")
    OrderDTO refusalToDeliveryOrder(@RequestBody OrderDeliveryUpdaterDTO dto) {
        return orderService.changeOfOrderDeliveryStatus(dto.getOrderId(), dto.getCourierId(), REFUSAL_TO_DELIVERY_ORDER);
    }

    @Operation(summary = "Completion of order by courier", security = @SecurityRequirement(name = "bearerAuth"))
    @MethodLogging
    @PostMapping("/complete")
    OrderDTO completeTheOrderForDelivery(@RequestBody OrderDeliveryUpdaterDTO dto) {
        return orderService.changeOfOrderDeliveryStatus(
                dto.getOrderId(), dto.getOrderId(), COMPLETE_THE_ORDER_FOR_DELIVERY
        );
    }
}
