package com.backendchalenger.store.unit;

import com.backendchalenger.store.exception.StoreInvalidException;
import com.backendchalenger.store.model.Store;
import com.backendchalenger.store.repository.StoreRepository;
import com.backendchalenger.store.service.StoreService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StoreTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test()
    public void shouldNotSaveStoreWhenNameFieldIsEmpty() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The name of store can not be empty or null or blank");

        final Store store                     = new Store("", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test()
    public void shouldNotSaveStoreWhenNameFieldIsBlank() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The name of store can not be empty or null or blank");

        final Store store                     = new Store(" ", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }


    @Test()
    public void shouldNotSaveStoreWhenNameFieldIsNull() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The name of store can not be empty or null or blank");

        final Store store                     = new Store(null, "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test()
    public void shouldNotSaveStoreWhenNameFieldIsTwoBlank() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The name of store can not be empty or null or blank");

        final Store store                     = new Store("  ", "Street Fake N° 123");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }


    @Test()
    public void shouldNotSaveStoreWhenStoreIsNull() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The store can not be null");

        final Store store                     = null;
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService       = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }
    @Test()
    public void shouldNotSaveStoreWhenAddressFieldIsEmpty() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The address of store can not be empty or null or blank");

        final Store store                     = new Store("Store1", "");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test()
    public void shouldNotSaveStoreWhenAddressFieldIsBlank() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The address of store can not be empty or null or blank");

        final Store store                     = new Store("Store1", " ");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }


    @Test()
    public void shouldNotSaveStoreWhenAddressFieldIsNull() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The address of store can not be empty or null or blank");

        final Store store                     = new Store("Store1", null);
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

        storeService.save(store);
        verify(storeRepository, times(0)).save(eq(store));
    }

    @Test()
    public void shouldNotSaveStoreWhenAddressFieldIsTwoBlank() throws StoreInvalidException {
        expectedException.expect(StoreInvalidException.class);
        expectedException.expectMessage("The address of store can not be empty or null or blank");

        final Store store                     = new Store("Store1", "  ");
        final StoreRepository storeRepository = mock(StoreRepository.class);
        final StoreService storeService      = new StoreService(storeRepository);

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
