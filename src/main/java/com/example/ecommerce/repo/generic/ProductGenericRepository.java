package com.example.ecommerce.repo.generic;

import com.example.ecommerce.repo.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProductGenericRepository extends GenericRepository<Product,Long> {
}
