package by.pvt.fooddelivery.exception;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum ApplicationError implements AppError, Supplier<ApplicationException> {
    USER_NOT_FOUND(NOT_FOUND, "User not found"),
    PRODUCT_NOT_FOUND(NOT_FOUND, "Product not found"),

    ORDER_NOT_FOUND(NOT_FOUND, "Order not found"),

    RESTAURANT_NOT_FOUND(NOT_FOUND, "Restaurant not found"),

    ADMIN_NOT_FOUND(NOT_FOUND, "Admin not found"),

    CLIENT_NOT_FOUND(NOT_FOUND, "Client not found"),

    COURIER_NOT_FOUND(NOT_FOUND, "Courier not found"),
    ERROR_ADDING_A_PRODUCT(BAD_REQUEST, "You cannot add a product from another restaurant"),
    PRODUCT_NOT_ADDED(BAD_REQUEST, "A product with the same name is already in the restaurant"),
    RESTAURANT_NOT_ADDED(BAD_REQUEST, "A restaurant with the same name already exists"),
    ADMIN_NOT_ADDED(BAD_REQUEST, "Admin already exists"),
    COURIER_NOT_ADDED(BAD_REQUEST, "Courier already exists"),
    CLIENT_NOT_ADDED(BAD_REQUEST, "Client already exists");

    private final HttpStatus status;
    private final String code;

    ApplicationError(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    @Override
    public ApplicationException get() {
        return new ApplicationException(this);
    }

    @Override
    public final HttpStatus getStatus() {
        return status;
    }

    @Override
    public final String getCode() {
        return code;
    }
}
