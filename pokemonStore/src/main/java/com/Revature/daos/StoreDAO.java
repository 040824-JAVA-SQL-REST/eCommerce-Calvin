package com.Revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.models.Store;
import com.Revature.utils.ConnectionFactory;

public class StoreDAO implements CrudDAO<Store>{

    @Override
    public Store save(Store obj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO stores (id, name, rating VALUES (?, ?, ?))")) {
            ps.setString(1, obj.getStore_id());
            ps.setString(2, obj.getStore_id());
            ps.setString(3, obj.getStore_id());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return obj;
    }

    @Override
    public Store update(Store obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Store delete(String ID) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE * FROM stores WHERE id = ?");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                Store store = new Store();
                store.setStore_id("id");
                store.setName("username");
                store.setRating("password");
                return store;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return null;
    }

    @Override
    public List<Store> findAll() {
        List<Store> stores = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM stores");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                Store store = new Store();
                store.setStore_id("id");
                store.setName("name");
                store.setRating("rating");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return stores;
    }

    @Override
    public Store findByID(String ID) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM stores WHERE id = ?");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                Store store = new Store();
                store.setStore_id("id");
                store.setName("username");
                store.setRating("rating");
                return store;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return null;
    }


    
}
