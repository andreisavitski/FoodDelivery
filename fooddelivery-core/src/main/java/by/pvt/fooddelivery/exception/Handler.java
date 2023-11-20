package by.pvt.fooddelivery.exception;

import by.pvt.fooddelivery.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class Handler {

    @ResponseBody
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ErrorResponse entityNotFound(ProductNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        log.error("Exception", e);
        return errorResponse;
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ErrorResponse entityNotFound(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Sorry, there were technical problems");
        errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        log.error("Exception", e);
        return errorResponse;
    }
}
