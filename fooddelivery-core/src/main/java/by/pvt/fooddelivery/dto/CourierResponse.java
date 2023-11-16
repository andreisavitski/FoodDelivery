package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.enums.CourierStatus;
import lombok.Data;

@Data
public class CourierResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String phoneNumber;
    private CourierStatus status;
}
