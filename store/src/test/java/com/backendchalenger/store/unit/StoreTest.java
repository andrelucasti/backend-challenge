package com.backendchalenger.store.unit;

import com.backendchalenger.store.handler.OrderHandler;
import com.backendchalenger.store.model.Order;
import com.backendchalenger.store.model.OrderStatus;
import com.backendchalenger.store.model.Store;
import com.backendchalenger.store.exception.StoreInvalidException;
import com.backendchalenger.store.repository.OrderRepository;
import com.backendchalenger.store.repository.StoreRepository;
import com.backendchalenger.store.service.OrderService;
import com.backendchalenger.store.service.StoreService;
import org.junit.Test;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StoreTest {

    @Test(expected = StoreInvalidException.class)
    public void shouldNotSaveStoreWhenNameFieldIsEmpty() throws StoreInvalidException {
        final Store store                     = new Store("", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final  StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test(expected = StoreInvalidException.class)
    public void shouldNotSaveStoreWhenNameFieldIsBlank() throws StoreInvalidException {
        final Store store                     = new Store(" ", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }


    @Test(expected = StoreInvalidException.class)
    public void shouldNotSaveStoreWhenNameFieldIsNull() throws StoreInvalidException {
        final Store store                     = new Store(null, "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final  StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test(expected = StoreInvalidException.class)
    public void shouldNotSaveStoreWhenNameFieldIsTwoBlank() throws StoreInvalidException {
        final Store store                     = new Store("  ", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final  StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }


    @Test(expected = StoreInvalidException.class)
    public void shouldNotSaveStoreWhenStoreIsNull() throws StoreInvalidException {
        final Store store                     = null;
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final  StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test
    public void shouldCreateStoreWhenIsValid() throws StoreInvalidException {
        final Store store                     = new Store("MyStore", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final  StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, atLeastOnce()).save(eq(store));
    }

    @Test
    public void shouldSaveAnOrderWhenReceiverAnOrder(){
        final Order order                     = new Order("Street Fake N° 123", LocalDate.now(), OrderStatus.PENDING);
        final OrderRepository orderRepository = mock(OrderRepository.class);
        final OrderService orderService       = new OrderService(orderRepository);
        final OrderHandler orderHandler       = new OrderHandler(orderService);

        orderHandler.execute();
        verify(orderRepository, atLeastOnce()).save(eq(order));
    }
}
