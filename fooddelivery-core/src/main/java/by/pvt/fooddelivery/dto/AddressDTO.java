package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class AddressDTO {
    @NotBlank
    private final String city;
    @NotBlank
    private final String street;
    @NotBlank
    private final String numberOfHouse;
    @NotBlank
    private final String index;
}
