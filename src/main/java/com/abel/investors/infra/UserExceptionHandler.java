package com.abel.investors.infra;

import com.abel.investors.exceptions.EmailException;
import com.abel.investors.exceptions.PasswordException;
import com.abel.investors.exceptions.UserNotFoundException;
import com.abel.investors.exceptions.UsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UsernameException.class)
    public ResponseEntity<?> usernameExceptionHandler(UsernameException exception) {
        RestErrorResponse response = this.newRestErrorResponse(exception.getMessage(), 400);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<?> emailExceptionHandler(EmailException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<?> passwordExceptionHandler(PasswordException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userExceptionHandler(UserNotFoundException exception) {
        RestErrorResponse response = this.newRestErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    private RestErrorResponse newRestErrorResponse(String errorMessage, int status) {
        Instant datetime = Instant.now();

        return new RestErrorResponse(datetime, status, errorMessage);
    }
}
