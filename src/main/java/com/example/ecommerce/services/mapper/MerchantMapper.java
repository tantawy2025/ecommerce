package com.example.ecommerce.services.mapper;

import com.example.ecommerce.commons.model.MerchantModel;
import com.example.ecommerce.repo.entity.Merchant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MerchantMapper {

    Merchant toEntity(MerchantModel merchantModel);

    MerchantModel toModel(Merchant merchant);
}
