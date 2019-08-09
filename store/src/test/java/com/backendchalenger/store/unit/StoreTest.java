package com.backendchalenger.store.unit;

import com.backendchalenger.store.exception.StoreInvalidException;
import com.backendchalenger.store.model.Store;
import com.backendchalenger.store.repository.StoreRepository;
import com.backendchalenger.store.service.StoreService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertSame;
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
        final StoreService storeService      = new StoreService(storeRepository);

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
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test(expected = StoreInvalidException.class)
    public void shouldNotSaveStoreWhenNameFieldIsTwoBlank() throws StoreInvalidException {
        final Store store                     = new Store("  ", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }


    @Test(expected = StoreInvalidException.class)
    public void shouldNotSaveStoreWhenStoreIsNull() throws StoreInvalidException {
        final Store store                     = null;
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService       = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test
    public void shouldCreateStoreWhenIsValid() throws StoreInvalidException {
        final Store store                     = new Store("MyStore", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService       = new StoreService(storeRepository);

        storeService.save(store);

        ArgumentCaptor<Store> argumentCaptor = ArgumentCaptor.forClass(Store.class);
        verify(storeRepository, atLeastOnce()).save(argumentCaptor.capture());

        assertSame(store.getName(), argumentCaptor.getValue().getName());
        assertSame(store.getAddress(), argumentCaptor.getValue().getAddress());

    }

}
