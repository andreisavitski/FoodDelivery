package by.pvt.fooddelivery.dto;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private AddressDTO addressDTO;
    private String phoneNumber;
    private List<ProductDTO> products;
}
