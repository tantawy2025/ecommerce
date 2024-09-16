package com.example.ecommerce.resources;

import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.commons.model.MerchantModel;
import com.example.ecommerce.services.CategoryService;
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

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Category Management APIs")
public class CategoryResource {

    private final CategoryService categoryService;





    @Operation(summary = "add new Category", description = "add new Category and return the created Category and status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> addNewCategory(@RequestBody CategoryModel categoryModel) {

        categoryService.create(categoryModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }





    @Operation(summary = "Get all Category", description = "Returns list of Category ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<CategoryModel>> retrieveAllCategories(Pageable pageable){

        Page<CategoryModel> categoryModels = categoryService.getAll(pageable);
        return new ResponseEntity<>(categoryModels, HttpStatus.OK);
    }





    @Operation(summary = "Get Category by id", description = "Returns Category as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<CategoryModel> retreiveCategoryById(@PathVariable Long id){

        CategoryModel categoryModel = categoryService.findById(id);

        return new ResponseEntity<>(categoryModel,HttpStatus.OK);
    }



    @Operation(summary = "update existing Category by id", description = "Returns the updated Category as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Role",content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable Long id, @RequestBody CategoryModel categoryModel){
        CategoryModel updatedCategory = categoryService.update(id,categoryModel);

        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }
}
