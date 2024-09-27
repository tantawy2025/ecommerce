package com.example.ecommerce.services.mapper;

import com.example.ecommerce.commons.model.OrderItemModel;
import com.example.ecommerce.repo.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {ProductMapper.class,OrderMapper.class})
public interface OrderItemMapper {

    @Mapping(target = "order.id", source = "orderId")
    @Mapping(target = "product.id", source = "productId")
    OrderItem toEntity(OrderItemModel orderItemModel);

    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "productId", source = "product.id")
    OrderItemModel toModel(OrderItem orderItem);
}
