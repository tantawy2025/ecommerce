package com.example.ecommerce.commons.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class MerchantModel {

    @Schema(name = "name", example = "join", required = true)
    private String name;

    @Schema(name = "email", example = "test@domian.com", required = true)
    private String email;

    @Schema(name = "address", example = "Apt. 760 447 Marianela Spurs, Mullerberg, CO 12140")
    private String address;

    @Schema(name = "status", example = "true")
    private boolean status;

}
