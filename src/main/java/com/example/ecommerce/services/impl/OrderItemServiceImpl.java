package com.example.ecommerce.services.impl;

import com.example.ecommerce.repo.entity.OrderItem;
import com.example.ecommerce.repo.OrderItemRepository;
import com.example.ecommerce.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
