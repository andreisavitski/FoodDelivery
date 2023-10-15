package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private ClientDTO client;
    private BigDecimal totalCost;
    private LocalDateTime ordered;
    private List<ProductDTO> products;
    private OrderStatus orderStatus;
}
