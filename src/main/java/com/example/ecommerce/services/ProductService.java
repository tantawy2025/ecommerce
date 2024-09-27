package com.example.ecommerce.services;

import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.repo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    public void create(ProductModel productModel);

    Page<ProductModel> getAll(Pageable pageable);

    ProductModel findById(Long id);


    ProductModel update(Long id, ProductModel productModel);

    void delete(Long id);

    List<Product> findByMerchantId(Long id);

//    Page<ProductModel> searchProductsByName(String name,Pageable pageable);
//
//    Page<ProductModel> searchProductsBySku(String sku,Pageable pageable);

}
