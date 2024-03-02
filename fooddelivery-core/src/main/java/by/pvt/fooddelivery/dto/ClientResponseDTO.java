package by.pvt.fooddelivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class ClientResponseDTO {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String login;
    private final AddressDTO addressDTO;
    private final String phoneNumber;
    private final String role;
}
