package by.pvt.fooddelivery.dto.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class SignUpRequestDTO {

    @Size(min = 5, max = 50)
    @NotBlank
    private final String username;

    @Size(min = 5, max = 255)
    @NotBlank
    @Email
    private final String email;

    @Size(max = 255)
    private final String password;
}
