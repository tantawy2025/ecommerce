package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.exception.AlreadyExistsException;
import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.mapper.CategoryMapper;
import com.example.ecommerce.repo.CategoryRepository;
import com.example.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    private final CategoryMapper categoryMapper;

    @Override
    public void create(CategoryModel categoryModel) {
        log.info("add  category ");
        validateCategoryExistance(categoryModel.getName());

        categoryRepo.save(categoryMapper.toEntity(categoryModel));
        log.info("category added successfully");
    }

    private void validateCategoryExistance(String name) {
        if (categoryRepo.findByName(name).isPresent()) {
            throw new AlreadyExistsException("Category name " + name + " already exists");
        }
    }
}
