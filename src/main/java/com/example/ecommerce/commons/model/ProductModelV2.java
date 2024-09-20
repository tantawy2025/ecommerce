package com.example.ecommerce.commons.model;

import com.example.ecommerce.repo.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class ProductModelV2 {

    @Column(name = "product_name", nullable = false)
    @Schema(description = "name", example = "Laptop", required = true)
    private String name;

    @Schema(description = "sku", example = "LAP123", required = true)
    private String sku;

    @Schema(description = "description", example = "A high-performance laptop")
    private String description;

}
