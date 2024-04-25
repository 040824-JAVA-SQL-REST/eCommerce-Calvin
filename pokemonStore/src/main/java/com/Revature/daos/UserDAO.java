package com.Revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.models.User;
import com.Revature.utils.ConnectionFactory;

public class UserDAO implements CrudDAO<User>{

    public UserDAO() {
        
    }

    @Override
    public User save(User obj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users (id, username, password, email, role_id) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, obj.getUserID());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getPassword());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getRole_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return obj;
    }

    @Override
    public User update(User obj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE users SET username=?, password=?, email=?, role_id=? WHERE id=?")) {
            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getRole_id());
            ps.setString(5, obj.getUserID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return obj;
    }

    @Override
    public User delete(String ID) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE * FROM users WHERE id = ?");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                User user = new User();
                user.setUserID("id");
                user.setUsername("username");
                user.setPassword("password");
                user.setEmail("email");
                user.setRole_id("role");
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                User user = new User();
                user.setUserID("id");
                user.setUsername("username");
                user.setPassword("password");
                user.setEmail("email");
                user.setRole_id("role");
                users.add(user);
                System.out.println("printing user");
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return users;
    }

    @Override
    public User findByID(String ID) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                User user = new User();
                user.setUserID("id");
                user.setUsername("username");
                user.setPassword("password");
                user.setEmail("email");
                user.setRole_id("role");
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return null;
    }

    public User userExists(String username, String password) {
        try ( Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM account WHERE username = ? AND password = ?");
        ResultSet rs = ps.executeQuery()){
            if (rs.next()) {
                System.out.println("found a user");
                User user = new User();
                user.setUserID("id");
                user.setUsername("username");
                user.setPassword("password");
                user.setEmail("email");
                user.setRole_id("role");
                return user;
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        } 
        catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return null;
    }
}
