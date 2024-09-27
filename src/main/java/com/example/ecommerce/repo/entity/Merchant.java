package com.example.ecommerce.repo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name = "merchant", schema = "ecommerce")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DynamicUpdate
public class Merchant extends IdentifiableEntity{


    @Email
    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @Column(name = "address")
    private String address= "No address added for this merchant";

    @Column(name = "status")
    private boolean status = true;



}