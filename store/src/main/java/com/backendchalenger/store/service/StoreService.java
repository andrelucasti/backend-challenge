package com.backendchalenger.store.service;

import com.backendchalenger.store.model.Store;
import com.backendchalenger.store.exception.StoreInvalidException;
import com.backendchalenger.store.repository.StoreRepository;
import org.apache.commons.lang3.StringUtils;

public class StoreService {

    private  StoreRepository storeRepository;

    public StoreService(final StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void save(final Store store) throws StoreInvalidException {
        if(store == null){
            throw  new StoreInvalidException("The store can not be null");
        }
        if(StringUtils.isBlank(store.getName()) || StringUtils.isEmpty(store.getName())){
            throw  new StoreInvalidException("The name of store can not be empty or null or blank");
        }
        if(StringUtils.isBlank(store.getAddress()) || StringUtils.isEmpty(store.getAddress())){
            throw  new StoreInvalidException("The address of store can not be empty or null or blank");
        }

        this.storeRepository.save(store);
    }
}
