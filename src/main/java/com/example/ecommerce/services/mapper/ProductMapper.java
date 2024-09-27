package com.example.ecommerce.services.mapper;

import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.repo.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",uses = {CategoryMapper.class,MerchantMapper.class})
public interface  ProductMapper {

    Product toEntity(ProductModel productModel);

    ProductModel toModel(Product product);
}
