package com.example.ecommerce.repo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @Schema(name = "email", example = "test@domian.com", required = true)
    private String email;

    @Column(name = "address")
    @Schema(name = "address", example = "Apt. 760 447 Marianela Spurs, Mullerberg, CO 12140")
    private String address= "No address added for this merchant";

    @Column(name = "status")
    @Schema(name = "status", example = "true")
    private boolean status = true;



}
