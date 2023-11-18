package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    @NotNull
    private RestaurantDTO restaurantDTO;
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    @Size(min = 1, max = 2000)
    private String description;
    @Positive
    private BigDecimal price;
    @NotNull
    private ProductType type;
}
