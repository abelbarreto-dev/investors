package com.abel.investors.infra;

import com.abel.investors.exceptions.StockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class StockExceptionHandler {
    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<?> stockNotFoundExceptionHandler(StockNotFoundException exception) {
        RestErrorResponse response = this.newRestErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    private RestErrorResponse newRestErrorResponse(String errorMessage, int status) {
        Instant datetime = Instant.now();

        return new RestErrorResponse(datetime, status, errorMessage);
    }
}
