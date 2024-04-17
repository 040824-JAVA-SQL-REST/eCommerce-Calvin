package com.Revature.daos;

import java.util.List;

public interface CrudDAO<T> {
    
    void save(T obj);

    void update(T obj);

    T delete(String ID);

    List<T> findAll();

    T findByID(String ID);
}
