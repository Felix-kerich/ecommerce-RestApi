package com.App.ecommerce.Security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.password.CompromisedPasswordException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CompromisedPasswordException.class)
    public ResponseEntity<String> handleCompromisedPasswordException(CompromisedPasswordException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password has been compromised. Please reset your password.");
    }
}
