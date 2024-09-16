package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.exception.AlreadyExistsException;
import com.example.ecommerce.commons.exception.NotFoundException;
import com.example.ecommerce.commons.model.CategoryModel;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Merchant;
import com.example.ecommerce.mapper.CategoryMapper;
import com.example.ecommerce.repo.CategoryRepository;
import com.example.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<CategoryModel> getAll(Pageable pageable) {
        Page<Category> categoryPage = categoryRepo.findAll(pageable);
        return categoryPage.map(categoryMapper::toModel);
    }

    @Override
    public CategoryModel findById(Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Category with ID " + id + " not found"));

        return categoryMapper.toModel(category);
    }

    @Override
    public CategoryModel update(Long id, CategoryModel categoryModel) {
        log.info("update Category by id {}",id);
        Category existingCategory =categoryRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Category with ID " + id + " not found"));

        // check duplicate email when updating the email
        if (!categoryModel.getName().isEmpty())
            validateCategoryExistance(categoryModel.getName());

        updateMerchantDetails(existingCategory, categoryModel);

        categoryRepo.save(existingCategory);
        log.info("Category updated successfully ");

        return categoryMapper.toModel(existingCategory);
    }

    private void updateMerchantDetails(Category existingCategory, CategoryModel categoryModel) {
        if (categoryModel.getName() != null) {
            existingCategory.setName(categoryModel.getName());
        }
        if (categoryModel.getDescription() != null) {
            existingCategory.setDescription(categoryModel.getDescription());
        }
    }

    private void validateCategoryExistance(String name) {
        if (categoryRepo.findByName(name).isPresent()) {
            throw new AlreadyExistsException("Category name " + name + " already exists");
        }
    }
}
