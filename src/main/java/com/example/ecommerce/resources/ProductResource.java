package com.example.ecommerce.resources;

import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.services.ProductService;
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

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Product Management APIs")
public class ProductResource {

    private final ProductService productService;





    @Operation(summary = "add new Product", description = "add new Product and return the status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> addNewProduct(@RequestBody ProductModel productModel) {

        productService.create(productModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }





    @Operation(summary = "Get all Product", description = "Returns list of Product ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<ProductModel>> retrieveAllProducts(Pageable pageable){

        Page<ProductModel> productModels = productService.getAll(pageable);
        return new ResponseEntity<>(productModels, HttpStatus.OK);
    }





    @Operation(summary = "Get Product by id", description = "Returns Product as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<ProductModel> retreiveProductById(@PathVariable Long id){

        ProductModel productModel = productService.findById(id);

        return new ResponseEntity<>(productModel,HttpStatus.OK);
    }

}
