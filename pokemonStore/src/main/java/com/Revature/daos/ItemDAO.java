package com.Revature.daos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.Revature.models.Item;

public class ItemDAO implements CrudDAO<Item>{

    @Override
    public Item save(Item obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Item update(Item obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Item delete(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();

        String line;
        try(
            InputStream is = getClass().getClassLoader().getResourceAsStream("db/item.txt");
            InputStreamReader isr = new InputStreamReader(is); 
            BufferedReader reader = new BufferedReader(isr)) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findByID(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }
    
}
