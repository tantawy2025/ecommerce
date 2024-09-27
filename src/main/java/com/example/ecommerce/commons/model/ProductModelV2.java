package com.example.ecommerce.commons.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProductModelV2 {

    private String name;

    private String sku;

    private String description;

}
