package com.example.ecommerce.repo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name = "category", schema = "ecommerce")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DynamicUpdate
public class Category extends IdentifiableEntity {

    @Column(name = "category_description")
    @Schema(name = "description", example = "electronic items")
    private String description;
}
