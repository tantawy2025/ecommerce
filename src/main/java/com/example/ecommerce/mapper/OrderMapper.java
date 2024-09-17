package com.example.ecommerce.mapper;

import com.example.ecommerce.commons.model.OrderModel;
import com.example.ecommerce.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderModel orderModel);

    OrderModel toModel(Order order);
}
