package by.pvt.fooddelivery.dto;

import lombok.Data;

@Data
public class OrderProductChangerDTO {
    private Long quantityProducts;
    private Long orderId;
    private Long productId;
}
