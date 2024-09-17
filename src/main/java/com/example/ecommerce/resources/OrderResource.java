package com.example.ecommerce.resources;

import com.example.ecommerce.commons.model.OrderModel;
import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.services.OrderService;
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
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
@Tag(name = "Order Management APIs")
public class OrderResource {

    private final OrderService orderService;





    @Operation(summary = "add new Order", description = "add new Order and return the status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> addNewOrder(@RequestBody OrderModel orderModel) {

        orderService.create(orderModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }






    @Operation(summary = "Get all Order", description = "Returns list of Order ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<OrderModel>> retrieveAllOrders(Pageable pageable){

        Page<OrderModel> orderModels = orderService.getAll(pageable);
        return new ResponseEntity<>(orderModels, HttpStatus.OK);
    }





    @Operation(summary = "Get Order by id", description = "Returns Order as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<OrderModel> retreiveOrderById(@PathVariable Long id){

        OrderModel orderModel = orderService.findById(id);

        return new ResponseEntity<>(orderModel,HttpStatus.OK);
    }
}
