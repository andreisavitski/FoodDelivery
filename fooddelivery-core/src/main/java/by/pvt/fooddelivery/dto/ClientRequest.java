package by.pvt.fooddelivery.dto;

import lombok.Data;

@Data
public class ClientRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private AddressDTO addressDTO;
    private String phoneNumber;
}
