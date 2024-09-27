package com.example.ecommerce.commons.model;

import lombok.Data;

import java.util.List;

@Data
public class MerchantProductsModel {

    private String name;

    private String email;

    private String address;

    private boolean status;

    private List<ProductModelV2> products;

}
