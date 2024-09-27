package com.example.ecommerce.commons.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemModel {


    private Long productId;


    private Long orderId;


    private Integer quantity;


    private BigDecimal price;
}
