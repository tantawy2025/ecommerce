package com.example.ecommerce.repo;

import com.example.ecommerce.repo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByName(String name);

    List<Product> findByMerchantId(Long merchantId);


    Page<Product> findAll(Pageable pageable); // Support for pagination

    // findAll with pageable can replace all the below
//    Page<Product> findByNameContainingIgnoreCase(String name,Pageable pageable);
//
//    Page<Product> findBySku(String sku,Pageable pageable);


}
