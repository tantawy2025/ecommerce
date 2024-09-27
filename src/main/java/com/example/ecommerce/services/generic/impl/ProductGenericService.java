package com.example.ecommerce.services.generic.impl;

import com.example.ecommerce.repo.ProductRepository;
import com.example.ecommerce.repo.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductGenericService extends GenericServiceImpl<Product, Long> {


    public ProductGenericService(ProductRepository repository) {
        super(repository);
    }

}
