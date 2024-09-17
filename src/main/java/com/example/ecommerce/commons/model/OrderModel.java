package com.example.ecommerce.commons.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderModel {


        @Schema(description = "customerId", example = "10", required = true)
        private Long customerId;


        @Schema(description = "orderDate", example = "2024-09-17T12:34:56", required = true)
        private LocalDateTime orderDate;


        @Schema(description = "totalAmount", example = "199.99", required = true)
        private BigDecimal totalAmount;

        @Schema(description = "orderStatus", example = "PENDING", required = true)
        private String orderStatus;

        @Schema(description = "shippingAddress", example = "123 Main St, Springfield", required = true)
        private String shippingAddress;

        @Schema(description = "billingAddress", example = "123 Main St, Springfield")
        private String billingAddress;

        @Schema(description = "paymentStatus", example = "PAID", required = true)
        private String paymentStatus;

}
