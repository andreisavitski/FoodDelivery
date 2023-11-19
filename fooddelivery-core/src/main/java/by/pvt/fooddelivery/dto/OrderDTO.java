package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class OrderDTO {
    private Long id;
    @NotBlank
    private String clientLogin;
    private BigDecimal totalCost;
    private BigDecimal serviceFee;
    private BigDecimal costOfDelivery;
    private LocalDateTime ordered;
    private Map<ProductDTO, Long> products;
    private OrderStatus orderStatus;
    private CourierResponseDTO courierResponseDTO;
}
