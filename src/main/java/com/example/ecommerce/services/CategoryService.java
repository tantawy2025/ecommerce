package com.example.ecommerce.services;

import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.commons.model.MerchantModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    public void create(CategoryModel categoryModel);

    public Page<CategoryModel> getAll(Pageable pageable);

    public CategoryModel findById(Long id);

    public CategoryModel update(Long id, CategoryModel merchantModel);


}
