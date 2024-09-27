package com.example.ecommerce.services.generic.impl;

import com.example.ecommerce.services.generic.GenericService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class GenericServiceImpl<T,ID> implements GenericService<T,ID> {

    private final JpaRepository<T, ID> repository;


    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T update(ID id, T entity) {
        Optional<T> existingEntity = repository.findById(id);
        if (existingEntity.isPresent()) {
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity not found");
        }
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
