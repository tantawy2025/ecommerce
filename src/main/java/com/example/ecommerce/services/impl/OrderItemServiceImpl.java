package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.exception.NotFoundException;
import com.example.ecommerce.repo.OrderItemRepository;
import com.example.ecommerce.repo.entity.OrderItem;
import com.example.ecommerce.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;


    @Override
    public void create(OrderItem orderItem) {
        log.info("add  order Item");
        orderItemRepository.save(orderItem);
        log.info("order item added successfully");
    }

    @Override
    public Page<OrderItem> getAll(Pageable pageable) {

        return orderItemRepository.findAll(pageable);
    }

    @Override
    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order Item with ID " + id + " not found"));
    }
}
