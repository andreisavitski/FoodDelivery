package by.pvt.fooddelivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class OrderMessageDTO {

    private Long clientId;

    private Long courierId;

    private BigDecimal totalCost;

    private LocalDateTime orderDate;
}
