package com.Revature.services;

import java.util.List;

import com.Revature.daos.StoreDAO;
import com.Revature.models.Store;

public class StoreService {

    private StoreDAO storeDAO;
    private final RoleService roleService;

    public StoreService(RoleService roleService, StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
        this.roleService = roleService;
    }

    public boolean isUnique(String name) {
        List<Store> stores = storeDAO.findAll();
        return stores.stream().noneMatch(s -> s.getName().equals(name));
    }

    public void save(Store store) {
        
    }

}
