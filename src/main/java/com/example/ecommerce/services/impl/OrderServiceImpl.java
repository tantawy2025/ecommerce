package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.model.OrderModel;
import com.example.ecommerce.mapper.MerchantMapper;
import com.example.ecommerce.mapper.OrderMapper;
import com.example.ecommerce.repo.MerchantRepository;
import com.example.ecommerce.repo.OrderRepository;
import com.example.ecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepo;

    private final OrderMapper orderMapper;


    @Override
    public void create(OrderModel orderModel) {
        log.info("add  order ");
        orderRepo.save(orderMapper.toEntity(orderModel));
        log.info("order added successfully");
    }
}
