package com.backendchalenger.store;

import com.backendchalenger.store.model.Store;
import com.backendchalenger.store.repository.StoreRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class StoreIntegrationTest extends StoreApplicationTests{

    @Autowired
    private StoreRepository storeRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotSaveStoreWhenStoreExistWithSameName() {
        final Store store1 = new Store("Store1", "My Fake Address Nº 123");
        storeRepository.save(store1);

        final Store storeSameName = new Store("Store1", "My Fake Address Nº 123");
        storeRepository.save(storeSameName);
    }

    @Test()
    public void shouldSaveStoreWhenStoreRepositoryInvoked() {
        final Store store1 = new Store("Store1", "My Fake Address Nº 123");
        final Store storeSaved = storeRepository.save(store1);

        assertNotNull(storeSaved.getId());
        assertSame(store1.getAddress(), storeSaved.getAddress());
        assertSame(store1.getName(), storeSaved.getName());
    }
}
