package com.example.ecommerce.mapper;

import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.entity.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {


    Category toEntity(CategoryModel categoryModel);

    CategoryModel toModel(Category category);
}
