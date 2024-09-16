package com.example.ecommerce.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MerchantExceptionHandler {

    @ExceptionHandler(MerchantNotFoundException.class)
    public ResponseEntity<String> handleMerchantNotFoundException(MerchantNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MerchantEmailAlreadyExistsException.class)
    public ResponseEntity<String> handleMerchantEmailAlreadyExistsException(MerchantEmailAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
