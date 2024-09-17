package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.exception.NotFoundException;
import com.example.ecommerce.commons.model.OrderModel;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.mapper.OrderMapper;
import com.example.ecommerce.repo.OrderRepository;
import com.example.ecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<OrderModel> getAll(Pageable pageable) {
        Page<Order> orderPage = orderRepo.findAll(pageable);
        return orderPage.map(orderMapper::toModel);
    }

    @Override
    public OrderModel findById(Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Order with ID " + id + " not found"));

        return orderMapper.toModel(order);
    }

}
