package by.pvt.fooddelivery.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private ClientDTO client;
    private AdminDTO admin;
    private CourierDTO courier;
    private String text;
}
