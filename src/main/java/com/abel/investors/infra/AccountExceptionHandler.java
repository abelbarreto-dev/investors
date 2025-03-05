package com.abel.investors.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.auth.login.AccountNotFoundException;
import java.time.Instant;

@ControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> accountNotFoundExceptionHandler(AccountNotFoundException exception) {
        RestErrorResponse response = this.newRestErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    private RestErrorResponse newRestErrorResponse(String errorMessage, int status) {
        Instant datetime = Instant.now();

        return new RestErrorResponse(datetime, status, errorMessage);
    }
}
