package com.example.ecommerce.mapper;

import com.example.ecommerce.commons.model.OrderItemModel;
import com.example.ecommerce.entity.OrderItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {ProductMapper.class,OrderMapper.class})
public interface OrderItemMapper {

    OrderItem toEntity(OrderItemModel orderItemModel);

    OrderItemModel toModel(OrderItem orderItem);
}
