package com.backendchalenger.store.repository;

import com.backendchalenger.store.model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "store", path = "store")
public interface  StoreRepository extends CrudRepository<Store, Long> {
}
