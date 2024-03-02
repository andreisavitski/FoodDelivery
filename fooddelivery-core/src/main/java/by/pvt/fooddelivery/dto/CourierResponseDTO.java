package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.enums.CourierStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CourierResponseDTO {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String login;
    private final String phoneNumber;
    private final CourierStatus status;
    private final String role;
}
