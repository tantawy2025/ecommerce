package com.example.ecommerce.repo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@DynamicUpdate
public class IdentifiableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;
}