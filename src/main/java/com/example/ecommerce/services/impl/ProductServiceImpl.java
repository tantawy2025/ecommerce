package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.exception.NotFoundException;
import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.repo.ProductRepository;
import com.example.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<ProductModel> getAll(Pageable pageable) {
        Page<Product> productPage = productRepo.findAll(pageable);
        return productPage.map(productMapper::toModel);
    }

    @Override
    public ProductModel findById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID " + id + " not found"));

        return productMapper.toModel(product);
    }


}
