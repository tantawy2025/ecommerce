package com.example.ecommerce.services.mapper;

import com.example.ecommerce.commons.model.OrderItemModel;
import com.example.ecommerce.repo.entity.OrderItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {ProductMapper.class,OrderMapper.class})
public interface OrderItemMapper {

    OrderItem toEntity(OrderItemModel orderItemModel);

    OrderItemModel toModel(OrderItem orderItem);
}
