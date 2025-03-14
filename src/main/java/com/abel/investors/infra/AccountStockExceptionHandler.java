package com.abel.investors.infra;

import com.abel.investors.exceptions.AccountStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class AccountStockExceptionHandler {
    @ExceptionHandler(AccountStockException.class)
    public ResponseEntity<?> handleAccountStockException(AccountStockException exception) {
        RestErrorResponse response = this.newRestErrorResponse(exception.getMessage(), exception.getStatus());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    private RestErrorResponse newRestErrorResponse(String errorMessage, int status) {
        Instant datetime = Instant.now();

        return new RestErrorResponse(datetime, status, errorMessage);
    }
}
