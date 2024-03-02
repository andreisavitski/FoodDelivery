package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@Jacksonized
public class OrderDTO {
    private final Long id;
    @NotBlank
    private final String clientLogin;
    private final BigDecimal totalCost;
    private final BigDecimal serviceFee;
    private final BigDecimal costOfDelivery;
    private final LocalDateTime ordered;
    private final Map<ProductDTO, Long> products;
    private final OrderStatus orderStatus;
    private final CourierResponseDTO courierResponseDTO;
}
