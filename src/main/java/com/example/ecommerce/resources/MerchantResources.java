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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/merchants")
@RequiredArgsConstructor
@Tag(name = "Merchant Management APIs")
public class MerchantResources {

    private final MerchantService merchantService;





    @Operation(summary = "add new Merchant", description = "add new Merchant and return the created Merchant and status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> addNewMerchant(@RequestBody MerchantModel merchantModel) {

        merchantService.create(merchantModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }





    @Operation(summary = "Get all merchants", description = "Returns list of merchants ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<MerchantModel>> retrieveAllMerchants(Pageable pageable){

        Page<MerchantModel> merchantModels = merchantService.getAll(pageable);
        return new ResponseEntity<>(merchantModels, HttpStatus.OK);
    }





    @Operation(summary = "Get merchant by id", description = "Returns merchant as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<MerchantModel> retreiveMerchantById(@PathVariable Long id){

        MerchantModel merchantModel = merchantService.findById(id);

        return new ResponseEntity<>(merchantModel,HttpStatus.OK);
    }





    @Operation(summary = "update existing merchant by id", description = "Returns the updated merchant as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Role",content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity<MerchantModel> updateRole(@PathVariable Long id, @RequestBody MerchantModel merchantModel){
        MerchantModel updatedMerchant = merchantService.update(id,merchantModel);

        return new ResponseEntity<>(updatedMerchant,HttpStatus.OK);
    }




    @Operation(summary = "delete existing merchant by id", description = "Returns no content ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Role",content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable Long id){
        merchantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
