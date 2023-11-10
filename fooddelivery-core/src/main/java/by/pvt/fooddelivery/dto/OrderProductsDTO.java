package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderProductsDTO {
    @NotNull
    private Long orderId;
    @NotNull
    private Long productId;
    @NotNull
    private Long quantityProducts;
}
