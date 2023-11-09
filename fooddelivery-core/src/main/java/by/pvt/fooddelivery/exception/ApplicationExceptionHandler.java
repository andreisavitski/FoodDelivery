package by.pvt.fooddelivery.exception;

import by.pvt.fooddelivery.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    private ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException applicationException) {
        return ResponseEntity.status(applicationException.getStatus()).body(new ErrorResponse(applicationException.getStatus(), applicationException.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> handleBaseException(Exception exception) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ErrorResponse(INTERNAL_SERVER_ERROR, exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException validException) {
        return ResponseEntity.status(validException.getStatusCode()).body(new ErrorResponse(validException.getStatusCode(), validException.getMessage()));
    }
}
