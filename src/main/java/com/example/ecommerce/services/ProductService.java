package com.example.ecommerce.services;

import com.example.ecommerce.commons.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public void create(ProductModel productModel);

    Page<ProductModel> getAll(Pageable pageable);

    ProductModel findById(Long id);


    ProductModel update(Long id, ProductModel productModel);

    void delete(Long id);
}
