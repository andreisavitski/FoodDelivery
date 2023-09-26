package by.pvt.fooddelivery.dto.foodestablishment;

import by.pvt.fooddelivery.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEstablishmentResponse {
    private Long id;
    private Long foodId;
    private String name;
    private Address address;
    private String phoneNumber;
}
