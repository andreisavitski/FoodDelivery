package by.pvt.fooddelivery.exception.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private Integer code;
}
