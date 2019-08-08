package com.backendchalenger.store.handler;

import com.backendchalenger.store.service.OrderService;

public class OrderHandler {
    private OrderService orderService;

    public OrderHandler(final OrderService orderService) {
        this.orderService = orderService;
    }

    public void execute() {
        
    }
}
