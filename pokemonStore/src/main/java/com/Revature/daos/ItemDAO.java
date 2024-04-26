package com.Revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.models.Item;
import com.Revature.utils.ConnectionFactory;

public class ItemDAO implements CrudDAO<Item>{
    
    @Override
    public Item save(Item obj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO items (id, name, value, grade) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, obj.getItem_id());
            ps.setString(2, obj.getName());
            ps.setInt(3, obj.getValue());
            ps.setInt(4, obj.getGrade());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return obj;
    }

    @Override
    public Item update(Item obj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE items SET name = ?, value = ?, grade = ? WHERE id = ?")) {
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getValue());
            ps.setInt(3, obj.getGrade());
            ps.setString(4, obj.getItem_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating item in the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return obj;
    }

    @Override
    public Item delete(String ID) {
        Item deletedItem = null;
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM items WHERE id = ?")) {
            ps.setString(1, ID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                deletedItem = new Item();
                deletedItem.setItem_id(ID);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting item from the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return deletedItem;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM items");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                Item item = new Item();
                item.setItem_id(rs.getString("id"));
                item.setName(rs.getString("name"));
                item.setValue(rs.getInt("value"));
                item.setGrade(rs.getInt("grade"));
                items.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return items;
    }

    @Override
    public Item findByID(String ID) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM items WHERE id = ?");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                Item item = new Item();
                item.setItem_id("id");
                item.setName("name");
                item.setValue(rs.getInt("value"));
                item.setGrade(rs.getInt("grade"));
                return item;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return null;
    }
    
}
