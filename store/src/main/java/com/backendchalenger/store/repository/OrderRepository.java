package com.backendchalenger.store.repository;

import com.backendchalenger.store.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "order", collectionResourceRel = "order")
public interface OrderRepository extends CrudRepository<Order, Long> {
}
