package com.example.ecommerce.repo;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(String name);

    Page<Category> findAll(Pageable pageable); // Support for pagination


}
