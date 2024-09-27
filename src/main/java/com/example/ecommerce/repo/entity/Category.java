package com.example.ecommerce.repo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name = "category", schema = "ecommerce")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Category extends IdentifiableEntity {

    @Column(name = "category_description")
    private String description;
}