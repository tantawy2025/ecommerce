package com.example.ecommerce.commons.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemModel {


    @Schema(description = "Product ID", example = "1", required = true)
    private Long productId;


    @Schema(description = "Order ID", example = "1001", required = true)
    private Long orderId;


    @Schema(description = "quantity", example = "2", required = true)
    private Integer quantity;


    @Schema(description = "unit_price", example = "999.99", required = true)
    private BigDecimal price;
}
