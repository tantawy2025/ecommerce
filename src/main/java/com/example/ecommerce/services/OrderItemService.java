package com.example.ecommerce.services;


import com.example.ecommerce.repo.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderItemService {

    public void create(OrderItem orderItem);

    Page<OrderItem> getAll(Pageable pageable);

    OrderItem findById(Long id);
}
