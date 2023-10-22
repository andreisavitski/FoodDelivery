package by.pvt.fooddelivery.dto;

import lombok.Data;

@Data
public class CourierDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private String phoneNumber;
}
