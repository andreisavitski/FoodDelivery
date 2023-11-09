package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    @Size(min = 1, max = 50)
    @NotBlank
    private String restaurantName;
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;
    @Size(min = 1, max = 2000)
    private String description;
    @Positive
    private BigDecimal price;
    private ProductType type;
}
