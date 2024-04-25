package com.Revature.services;

import java.util.List;

import com.Revature.daos.StoreDAO;
import com.Revature.models.Store;

public class StoreService {

    private StoreDAO storeDAO;

    public StoreService(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public boolean isUnique(String name) {
        List<Store> stores = storeDAO.findAll();
        return stores.stream().noneMatch(s -> s.getName().equals(name));
    }

    public void save(Store store) {
        
    }

}
