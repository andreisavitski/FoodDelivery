package by.pvt.fooddelivery.dto;

import lombok.Data;

@Data
public class AdminResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String phoneNumber;
    private String role;
}
