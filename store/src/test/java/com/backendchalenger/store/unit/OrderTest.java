package com.backendchalenger.store.unit;

import com.backendchalenger.store.handler.OrderHandler;
import com.backendchalenger.store.model.Order;
import com.backendchalenger.store.model.OrderStatus;
import com.backendchalenger.store.model.Store;
import com.backendchalenger.store.repository.OrderRepository;
import com.backendchalenger.store.service.OrderService;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderTest {

    @Test
    public void shouldCreateAnOrderWhenReceiverSyncAnOrder(){
        final Store store                     = new Store("MyStore", "Street Fake N° 123");
        final Order order                     = new Order("Street Fake N° 123", LocalDate.now(), OrderStatus.PENDING, store);
        final OrderRepository orderRepository = mock(OrderRepository.class);
        final OrderService orderService       = new OrderService(orderRepository);

        ArgumentCaptor<Order> argumentCaptor = ArgumentCaptor.forClass(Order.class);

        orderService.save(order);
        verify(orderRepository).save(argumentCaptor.capture());

        final String storeNameExpected = order.getStore().getName();
        final String orderAddressExpected = order.getAddress();
        final OrderStatus orderStatusExpected = order.getOrderStatus();
        assertSame(storeNameExpected, argumentCaptor.getValue().getStore().getName());
        assertSame(orderAddressExpected, argumentCaptor.getValue().getAddress());
        assertSame(orderStatusExpected, argumentCaptor.getValue().getOrderStatus());
    }


    @Test
    @Ignore("Not implemented yet")
    public void shouldSaveAnOrderWhenReceiverAsyncAnOrder(){
        final Store store                     = new Store("MyStore", "Street Fake N° 123");
        final Order order                     = new Order("Street Fake N° 123", LocalDate.now(), OrderStatus.PENDING, store);
        final OrderRepository orderRepository = mock(OrderRepository.class);
        final OrderService orderService       = new OrderService(orderRepository);
        final OrderHandler orderHandler       = new OrderHandler(orderService);

        orderHandler.execute();
        verify(orderRepository, atLeastOnce()).save(eq(order));
    }
}
