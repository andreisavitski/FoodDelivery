package by.pvt.fooddelivery.dto.security;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class SignInRequestDTO {
    @Size(min = 4, max = 50)
    @NotBlank
    private final String login;
    @Size(min = 8, max = 255)
    @NotBlank
    private final String password;
}
