package by.pvt.fooddelivery.dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private AddressDTO addressDTO;
    private String phoneNumber;
}
