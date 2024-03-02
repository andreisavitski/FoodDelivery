package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import static by.pvt.fooddelivery.constant.AppConstants.PHONE_NUMBER_VALIDATION;

@Getter
@Builder
@Jacksonized
public class RestaurantDTO {
    private final Long id;
    @NotBlank
    private final String name;
    @NotNull
    private final AddressDTO addressDTO;
    @Pattern(regexp = PHONE_NUMBER_VALIDATION)
    private final String phoneNumber;
}
