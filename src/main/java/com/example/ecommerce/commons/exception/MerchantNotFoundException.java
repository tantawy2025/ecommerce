package com.example.ecommerce.commons.exception;

public class MerchantNotFoundException extends RuntimeException{

    public MerchantNotFoundException(Long merchantId) {
        super("Merchant with ID " + merchantId + " not found");
    }
}
