package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.enums.ProductType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private RestaurantDTO restaurantDTO;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductType type;
}
