package com.Revature.daos;

import java.io.IOException;
import java.util.List;

public interface CrudDAO<T> {
    
    T save(T obj);

    T update(T obj);

    T delete(String ID);

    List<T> findAll() throws IOException;

    T findByID(String ID);
}
