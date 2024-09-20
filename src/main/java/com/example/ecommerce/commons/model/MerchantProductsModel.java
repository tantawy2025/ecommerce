package com.example.ecommerce.commons.model;

import com.example.ecommerce.repo.entity.Merchant;
import com.example.ecommerce.repo.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class MerchantProductsModel {

    @Schema(name = "name", example = "join", required = true)
    private String name;

    @Schema(name = "email", example = "test@domian.com", required = true)
    private String email;

    @Schema(name = "address", example = "Apt. 760 447 Marianela Spurs, Mullerberg, CO 12140")
    private String address;

    @Schema(name = "status", example = "true")
    private boolean status;

    @Schema(description = "product", example = "1")
    private List<ProductModelV2> products;

}
