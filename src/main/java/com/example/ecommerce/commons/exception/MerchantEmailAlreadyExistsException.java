package com.example.ecommerce.commons.exception;

public class MerchantEmailAlreadyExistsException extends IllegalArgumentException {

    public MerchantEmailAlreadyExistsException(String email) {
        super("Merchant email " + email + " already exists");
    }

}

