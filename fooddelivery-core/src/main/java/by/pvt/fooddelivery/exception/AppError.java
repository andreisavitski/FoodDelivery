package by.pvt.fooddelivery.exception;

import org.springframework.http.HttpStatus;

public interface AppError {
    HttpStatus getStatus();

    String getCode();
}
