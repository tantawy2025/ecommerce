package com.example.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "order", schema = "ecommerce")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", columnDefinition = "serial")
    @Schema(description = "id", example = "1", required = true)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    @Schema(description = "customerId", example = "10", required = true)
    private Long customerId;


    @Column(name = "order_date", nullable = false)
    @Schema(description = "orderDate", example = "2024-09-17T12:34:56", required = true)
    private LocalDateTime orderDate;


    @Column(name = "total_amount", nullable = false)
    @Schema(description = "totalAmount", example = "199.99", required = true)
    private BigDecimal totalAmount;

    @Column(name = "order_status", nullable = false)
    @Schema(description = "orderStatus", example = "PENDING", required = true)
    private String orderStatus;

    @Column(name = "shipping_address", nullable = false)
    @Schema(description = "shippingAddress", example = "123 Main St, Springfield", required = true)
    private String shippingAddress;

    @Column(name = "billing_address")
    @Schema(description = "billingAddress", example = "123 Main St, Springfield")
    private String billingAddress;

    @Column(name = "payment_status", nullable = false)
    @Schema(description = "paymentStatus", example = "PAID", required = true)
    private String paymentStatus;
}
