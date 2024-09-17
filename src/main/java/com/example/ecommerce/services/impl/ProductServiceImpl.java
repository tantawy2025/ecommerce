package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.repo.ProductRepository;
import com.example.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;

    private final ProductMapper productMapper;


    @Override
    public void create(ProductModel productModel) {

        log.info("add  product ");
        //validateProductExistance(productModel);

        productRepo.save(productMapper.toEntity(productModel));
        log.info("product added successfully");

    }
}
