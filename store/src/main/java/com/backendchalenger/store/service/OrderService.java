package com.backendchalenger.store.service;

import com.backendchalenger.store.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
