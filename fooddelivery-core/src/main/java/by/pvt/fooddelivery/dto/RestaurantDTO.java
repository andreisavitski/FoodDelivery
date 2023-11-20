package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import static by.pvt.fooddelivery.constant.AppConstants.PHONE_NUMBER_VALIDATION;

@Data
public class RestaurantDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private AddressDTO addressDTO;
    @Pattern(regexp = PHONE_NUMBER_VALIDATION)
    private String phoneNumber;
}
