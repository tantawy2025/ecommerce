package com.example.ecommerce.resources;

import com.example.ecommerce.commons.model.MerchantModel;
import com.example.ecommerce.entity.Merchant;
import com.example.ecommerce.services.MerchantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("merchants")
@RequiredArgsConstructor
@Tag(name = "Merchant Management APIs")
public class MerchantResources {

    private final MerchantService merchantService;

    @Operation(summary = "add new Merchant", description = "add new Merchant and return the created Merchant and status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist",content = @Content)
    })
    @PostMapping
    public void createRole(@RequestBody MerchantModel merchantModel){

        Merchant savedMerchant = merchantService.create(merchantModel);


    }

}
