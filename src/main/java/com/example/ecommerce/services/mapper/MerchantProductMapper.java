package com.example.ecommerce.services.mapper;

import com.example.ecommerce.commons.model.ProductModelV2;
import com.example.ecommerce.repo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MerchantProductMapper {


    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "sku", source = "product.sku")
    ProductModelV2 toModel(Product product);

    List<ProductModelV2> toProductModelList(List<Product> products);
}
