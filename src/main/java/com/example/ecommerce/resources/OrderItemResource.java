package com.example.ecommerce.resources;

import com.example.ecommerce.commons.model.OrderItemModel;
import com.example.ecommerce.commons.model.OrderModel;
import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.repo.entity.Order;
import com.example.ecommerce.repo.entity.OrderItem;
import com.example.ecommerce.repo.entity.Product;
import com.example.ecommerce.services.OrderItemService;
import com.example.ecommerce.services.OrderService;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.services.mapper.OrderMapper;
import com.example.ecommerce.services.mapper.ProductMapper;
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
@RequestMapping("v1/order-items")
@RequiredArgsConstructor
@Tag(name = "Order Item Management APIs")
public class OrderItemResource {

    private final OrderItemService orderItemService;
    private final OrderService orderService;
    private final ProductService productService;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;

    @Operation(summary = "add new Order Item", description = "add new Order Item and return the status created ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "role already exist", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> addNewOrderItem(@RequestBody OrderItemModel orderItemModel) {

        OrderModel orderModel = orderService.findById(orderItemModel.getOrderId());
        Order order = orderMapper.toEntity(orderModel);
        order.setId(orderItemModel.getOrderId());

        ProductModel productModel = productService.findById(orderItemModel.getProductId());
        Product product = productMapper.toEntity(productModel);
        product.setId(orderItemModel.getProductId());

        OrderItem orderItem = OrderItem.builder()
                        .order(order)
                                .product(product)
                                        .quantity(orderItemModel.getQuantity())
                                                .price(orderItemModel.getPrice())
                                                        .build();


        orderItemService.create(orderItem);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Operation(summary = "Get all Order items", description = "Returns list of Order items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<OrderItem>> retrieveAllOrderItems(Pageable pageable){

        Page<OrderItem> orderItems = orderItemService.getAll(pageable);
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

    @Operation(summary = "Get Order item by id", description = "Returns Order item as per the id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found - No Roles",content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<OrderItem> retreiveOrderItemById(@PathVariable Long id){

        OrderItem orderItem = orderItemService.findById(id);

        return new ResponseEntity<>(orderItem,HttpStatus.OK);
    }





}
