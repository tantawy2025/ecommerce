package com.example.ecommerce.services.mapper;

import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.repo.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description") // Ensure this mapping if applicable
    Category toEntity(CategoryModel categoryModel);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description") // Ensure this mapping if applicable
    CategoryModel toModel(Category category);
}
