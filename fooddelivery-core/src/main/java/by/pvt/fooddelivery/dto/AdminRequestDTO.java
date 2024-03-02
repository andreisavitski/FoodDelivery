package by.pvt.fooddelivery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import static by.pvt.fooddelivery.constant.AppConstants.PASSWORD_VALIDATION;
import static by.pvt.fooddelivery.constant.AppConstants.PHONE_NUMBER_VALIDATION;

@Getter
@Builder
@Jacksonized
public class AdminRequestDTO {
    private final Long id;
    @NotBlank
    @Size(min = 1, max = 50)
    private final String firstName;
    @NotBlank
    @Size(min = 1, max = 50)
    private final String lastName;
    @Email
    private final String email;
    @NotBlank
    @Size(min = 1, max = 50)
    private final String login;
    @Pattern(regexp = PASSWORD_VALIDATION)
    private final String password;
    @Pattern(regexp = PHONE_NUMBER_VALIDATION)
    private final String phoneNumber;
}
