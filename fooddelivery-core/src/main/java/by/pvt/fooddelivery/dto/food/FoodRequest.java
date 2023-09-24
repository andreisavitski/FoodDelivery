package by.pvt.fooddelivery.dto.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequest {
    private Long id;
    private Long foodEstablishmentId;
    private String name;
    private String description;
    private BigDecimal price;
    private String typeOfFood;
}
