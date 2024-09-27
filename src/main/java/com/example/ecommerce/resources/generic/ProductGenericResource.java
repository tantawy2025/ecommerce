package com.example.ecommerce.resources.generic;

import com.example.ecommerce.repo.entity.Product;
import com.example.ecommerce.services.generic.impl.ProductGenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/products")
public class ProductGenericResource  extends GenericResource<Product, Long> {

    public ProductGenericResource(ProductGenericService productGenericService) {
        super(productGenericService);
    }
}
