package com.example.ecommerce.repo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "order_details", schema = "ecommerce")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", columnDefinition = "serial")
    @Schema(description = "id", example = "1", required = true)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    @Schema(description = "Product ID", example = "1", required = true)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    @Schema(description = "Order ID", example = "1001", required = true)
    private Order order;

    @Column(name = "quantity")
    @Schema(description = "quantity", example = "2", required = true)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    @Schema(description = "unit_price", example = "999.99", required = true)
    private BigDecimal price;

}
