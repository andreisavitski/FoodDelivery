package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import static by.pvt.fooddelivery.constant.AppConstants.PASSWORD_VALIDATION;
import static by.pvt.fooddelivery.constant.AppConstants.PHONE_NUMBER_VALIDATION;

@Data
public class ClientRequestDTO {
    private Long id;
    @NotBlank
    @Size(min = 1, max = 50)
    private String firstName;
    @NotBlank
    @Size(min = 1, max = 50)
    private String lastName;
    @Email
    private String email;
    @NotBlank
    @Size(min = 1, max = 50)
    private String login;
    @Pattern(regexp = PASSWORD_VALIDATION)
    private String password;
    @NotNull
    private AddressDTO addressDTO;
    @Pattern(regexp = PHONE_NUMBER_VALIDATION)
    private String phoneNumber;
}
