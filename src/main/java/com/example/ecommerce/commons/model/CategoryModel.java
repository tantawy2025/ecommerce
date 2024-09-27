package com.example.ecommerce.commons.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoryModel {

    @Schema(name = "name", example = "electronic", required = true)
    private String name;

    @Schema(name = "description", example = "electronic items", required = true)
    private String description;
}
