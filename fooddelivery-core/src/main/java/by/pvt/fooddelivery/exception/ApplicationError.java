package by.pvt.fooddelivery.exception;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public enum ApplicationError implements AppError, Supplier<ApplicationException> {
    PRODUCT_NOT_FOUND(NOT_FOUND, "Product not found"),

    ORDER_NOT_FOUND(NOT_FOUND, "Order not found"),

    RESTAURANT_NOT_FOUND(NOT_FOUND, "Restaurant not found"),

    ADMIN_NOT_FOUND(NOT_FOUND, "Admin not found"),

    CLIENT_NOT_FOUND(NOT_FOUND, "Client not found"),

    COURIER_NOT_FOUND(NOT_FOUND, "Courier not found");

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
