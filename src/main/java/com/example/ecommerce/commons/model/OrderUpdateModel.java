package com.example.ecommerce.commons.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderUpdateModel {

    @Schema(description = "orderStatus", example = "PENDING", required = true)
    private String orderStatus;

    @Schema(description = "billingAddress", example = "123 Main St, Springfield")
    private String billingAddress;
}
