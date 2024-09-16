package com.example.ecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name = "category", schema = "ecommerce")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "serial")
    @Schema(name = "id", example = "1", required = true)
    private Long id;

    @NotBlank
    @Column(name = "category_name",nullable = false)
    @Schema(name = "name", example = "Electronics", required = true)
    private String name;

    @Column(name = "category_description")
    @Schema(name = "name", example = "electronic items")
    private String description;
}
