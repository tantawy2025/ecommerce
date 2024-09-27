package com.example.ecommerce.repo.entity;

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
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;


    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;


    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;
}