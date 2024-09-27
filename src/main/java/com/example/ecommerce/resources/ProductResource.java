package com.example.ecommerce.resources;

import com.example.ecommerce.commons.model.ProductModel;
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
@RequestMapping("v1/products")
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



    @Operation(summary = "update existing Product by id", description = "Returns the updated Product as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Role",content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel){
        ProductModel updatedProduct = productService.update(id,productModel);

        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }





    @Operation(summary = "delete existing Product by id", description = "Returns no content ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Role",content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//
//    // get all with pageable can replace all the below
//
//    @GetMapping("/search/name")
//    public ResponseEntity<Page<ProductModel>> searchProductsByName(@RequestParam String name,Pageable pageable) {
//        Page<ProductModel> products = productService.searchProductsByName(name,pageable);
//        if (products.isEmpty()) {
//            return ResponseEntity.noContent().build();  // Return 204 if no products found
//        }
//        return ResponseEntity.ok(products);  // Return 200 and the list of products
//    }
//
//    // Search products by SKU
//    @GetMapping("/search/sku")
//    public ResponseEntity<Page<ProductModel>> searchProductsBySku(@RequestParam String sku,Pageable pageable) {
//        Page<ProductModel> products = productService.searchProductsBySku(sku,pageable);
//        if (products.isEmpty()) {
//            return ResponseEntity.notFound().build();  // Return 404 if no product found
//        }
//        return ResponseEntity.ok(products);  // Return the product (SKU should be unique, so one product)
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<Page<ProductModel>> searchProducts(@RequestParam(required = false) String name,
//                                                             @RequestParam(required = false) String sku,
//                                                             @RequestParam(required = false) Long id,
//                                                             Pageable pageable) {
//
//        // If SKU is provided, search by SKU
//        if (sku != null) {
//            Page<ProductModel> products = productService.searchProductsBySku(sku,pageable);
//            if (products.isEmpty()) {
//                return ResponseEntity.notFound().build();  // Return 404 if no product found
//            }
//            return ResponseEntity.ok(products);
//        }
//
//        // If name is provided, search by name
//        if (name != null) {
//            Page<ProductModel> products = productService.searchProductsByName(name,pageable);
//            if (products.isEmpty()) {
//                return ResponseEntity.noContent().build();  // Return 204 if no products found
//            }
//            return ResponseEntity.ok(products);  // Return 200 and the list of products
//        }
//
//        Page<ProductModel> productModels = productService.getAll(pageable);
//        return new ResponseEntity<>(productModels, HttpStatus.OK);
//
//    }

}
