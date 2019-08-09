package com.backendchalenger.store;

import com.backendchalenger.store.model.Store;
import com.backendchalenger.store.repository.StoreRepository;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

public class StoreIntegrationTest extends StoreApplicationTests{

    private ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private StoreRepository storeRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotCreateStoreWhenStoreExistWithSameName() {
        final Store store1 = new Store("Store1", "My Fake Address Nº 123");
        storeRepository.save(store1);

        final Store storeSameName = new Store("Store1", "My Fake Address Nº 123");
        storeRepository.save(storeSameName);
    }
}
