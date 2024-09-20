package com.example.ecommerce.resources;

import com.example.ecommerce.commons.model.OrderItemModel;
import com.example.ecommerce.commons.model.OrderModel;
import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.repo.entity.Order;
import com.example.ecommerce.repo.entity.OrderItem;
import com.example.ecommerce.repo.entity.Product;
import com.example.ecommerce.services.mapper.OrderMapper;
import com.example.ecommerce.services.mapper.ProductMapper;
import com.example.ecommerce.services.OrderItemService;
import com.example.ecommerce.services.OrderService;
import com.example.ecommerce.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
