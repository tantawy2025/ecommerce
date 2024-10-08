package com.example.ecommerce.services;

import com.example.ecommerce.commons.model.OrderModel;
import com.example.ecommerce.commons.model.OrderUpdateModel;
import com.example.ecommerce.commons.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    public void create(OrderModel orderModel);

    Page<OrderModel> getAll(Pageable pageable);

    OrderModel findById(Long id);

    OrderModel update(Long id, OrderUpdateModel orderUpdateModel);

    void delete(Long id);
}
