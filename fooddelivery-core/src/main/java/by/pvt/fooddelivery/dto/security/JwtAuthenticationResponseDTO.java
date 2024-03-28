package by.pvt.fooddelivery.dto.security;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@ToString
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponseDTO {

    private String token;
}
