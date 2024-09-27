package com.example.ecommerce.commons.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderModel {


        private Long customerId;


        private LocalDateTime orderDate;


        private BigDecimal totalAmount;

        private String orderStatus;

        private String shippingAddress;

        private String billingAddress;

        private String paymentStatus;

}
