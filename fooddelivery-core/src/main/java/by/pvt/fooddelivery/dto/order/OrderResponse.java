package by.pvt.fooddelivery.dto.order;

import by.pvt.fooddelivery.enam.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private Long userId;
    private BigDecimal totalCost;
    private OrderStatus orderStatus;
    private LocalDateTime ordered;
}
