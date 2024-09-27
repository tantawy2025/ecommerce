package com.example.ecommerce.services;

import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.commons.model.MerchantModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

 public interface CategoryService {

     void create(CategoryModel categoryModel);

     Page<CategoryModel> getAll(Pageable pageable);

     CategoryModel findById(Long id);

     CategoryModel update(Long id, CategoryModel merchantModel);

     void delete(Long id);

}
