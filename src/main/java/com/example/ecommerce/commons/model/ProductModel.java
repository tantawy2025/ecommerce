package com.example.ecommerce.commons.model;

import com.example.ecommerce.repo.entity.Category;
import com.example.ecommerce.repo.entity.Merchant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductModel {

    @Column(name = "product_name", nullable = false)
    @Schema(description = "name", example = "Laptop", required = true)
    private String name;


    @Schema(description = "sku", example = "LAP123", required = true)
    private String sku;

    @Schema(description = "description", example = "A high-performance laptop")
    private String description;

    @Schema(description = "price", example = "999.99", required = true)
    private BigDecimal price;

    @Schema(description = "stock", example = "50", required = true)
    private Integer stock;

    @Schema(description = "status", example = "true", required = true)
    private Boolean status = true;

    @Schema(description = "category", example = "1")
    private Category category;

    @Schema(description = "merchant", example = "1")
    private Merchant merchant;


}
