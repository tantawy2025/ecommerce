package com.example.ecommerce.repo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DynamicUpdate
@Table(name = "product", schema = "ecommerce")
public class Product extends IdentifiableEntity {


    @Column(name = "sku", nullable = false, unique = true)
    @Schema(description = "sku", example = "LAP123", required = true)
    private String sku;

    @Column(name = "description")
    @Schema(description = "description", example = "A high-performance laptop")
    private String description;

    @Column(name = "price", nullable = false)
    @Schema(description = "price", example = "999.99", required = true)
    private BigDecimal price;

    @Column(name = "stock")
    @Schema(description = "stock", example = "50", required = true)
    private Integer stock;

    @Column(name = "status", nullable = false)
    @Schema(description = "status", example = "true", required = true)
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @Schema(description = "category", example = "1")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")
    @Schema(description = "merchant", example = "1")
    private Merchant merchant;

}
