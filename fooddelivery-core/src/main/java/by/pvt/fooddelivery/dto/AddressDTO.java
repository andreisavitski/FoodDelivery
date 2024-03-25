package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@Builder
@Jacksonized
public class AddressDTO {

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    private String numberOfHouse;

    @NotBlank
    private String index;
}
