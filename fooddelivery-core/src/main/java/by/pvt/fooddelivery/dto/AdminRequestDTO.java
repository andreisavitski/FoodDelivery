package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static by.pvt.fooddelivery.constant.AppConstants.PASSWORD_VALIDATION;
import static by.pvt.fooddelivery.constant.AppConstants.PHONE_NUMBER_VALIDATION;

@Data
public class AdminRequestDTO {
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
    @Pattern(regexp = PHONE_NUMBER_VALIDATION)
    private String phoneNumber;
}
