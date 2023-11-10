package by.pvt.fooddelivery.dto;

import lombok.Data;

@Data
public class ClientResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private AddressDTO addressDTO;
    private String phoneNumber;
}