package com.example.ecommerce.repo;

import com.example.ecommerce.repo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByName(String name);


    Page<Product> findAll(Pageable pageable); // Support for pagination


}
