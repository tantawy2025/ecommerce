package com.example.ecommerce.commons.model;

import com.example.ecommerce.repo.entity.Category;
import com.example.ecommerce.repo.entity.Merchant;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductModel {

    private String name;


    private String sku;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private Boolean status = true;

    private Category category;

    private Merchant merchant;


}
