package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
