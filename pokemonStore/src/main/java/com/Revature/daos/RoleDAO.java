package com.Revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.models.Role;
import com.Revature.utils.ConnectionFactory;

public class RoleDAO implements CrudDAO<Role> {

    @Override
    public Role save(Role obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Role update(Role obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Role delete(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM roles");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                Role role = new Role();
                role.setId(rs.getString("id"));
                role.setName(rs.getString("name"));
                roles.add(role);
                System.out.println("added: " + role.getName());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return roles;
    }

    @Override
    public Role findByID(String ID) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM roles WHERE id = ?");
        ResultSet rs = ps.executeQuery();) {
            while(rs.next()) {
                Role role = new Role();
                role.setId(rs.getString("id"));
                role.setName(rs.getString("name"));
                return role;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return null;
    }
}
