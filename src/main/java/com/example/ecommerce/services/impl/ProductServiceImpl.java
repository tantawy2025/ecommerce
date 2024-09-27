package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.exception.AlreadyExistsException;
import com.example.ecommerce.commons.exception.NotFoundException;
import com.example.ecommerce.commons.model.ProductModel;
import com.example.ecommerce.repo.entity.Product;
import com.example.ecommerce.services.mapper.ProductMapper;
import com.example.ecommerce.repo.ProductRepository;
import com.example.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;

    private final ProductMapper productMapper;


    @Override
    public void create(ProductModel productModel) {

        log.info("add  product ");
        validateProductExistance(productModel.getName());

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

    @Override
    public ProductModel update(Long id, ProductModel productModel) {
        log.info("update product by id {}",id);
        Product existingProduct =productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("product with ID " + id + " not found"));

        // check duplicate name when updating the email
        if (!productModel.getName().isEmpty())
            validateProductExistance(productModel.getName());

        existingProduct = productMapper.toEntity(productModel);

        productRepo.save(existingProduct);
        log.info("product updated successfully ");

        return productMapper.toModel(existingProduct);
    }

    @Override
    public void delete(Long id) {
        log.info("product merchant by id");
        Boolean exist = productRepo.existsById(id);

        if(exist)
            productRepo.deleteById(id);
        else
            throw new NotFoundException("product with ID " + id + " not found");

        log.info("product deleted successfully ");
    }

    @Override
    public List<Product> findByMerchantId(Long id) {
        return productRepo.findByMerchantId(id);

    }

//    @Override
//    public Page<ProductModel> searchProductsByName(String name,Pageable pageable) {
//        return productRepo.findByNameContainingIgnoreCase(name,pageable).map(productMapper::toModel);
//
//    }
//
//    @Override
//    public Page<ProductModel> searchProductsBySku(String sku,Pageable pageable) {
//        return productRepo.findBySku(sku,pageable).map(productMapper::toModel);
//    }


    private void validateProductExistance(String name) {
        if (productRepo.findByName(name).isPresent()) {
            throw new AlreadyExistsException("Product name " + name + " already exists");
        }
    }


}
