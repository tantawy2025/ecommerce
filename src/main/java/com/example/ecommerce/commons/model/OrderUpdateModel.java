package com.example.ecommerce.commons.model;

import lombok.Data;

@Data
public class OrderUpdateModel {

    private String orderStatus;

    private String billingAddress;
}
