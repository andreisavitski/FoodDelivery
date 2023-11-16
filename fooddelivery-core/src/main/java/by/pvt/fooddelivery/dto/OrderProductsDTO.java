package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderProductsDTO {
    @NotNull
    private Long orderId;
    @NotNull
    private Long productId;
    @Positive
    private Long quantityProducts;
}
