package by.pvt.fooddelivery.dto;

import by.pvt.fooddelivery.domain.Address;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private String phoneNumber;
    private Address address;
}
