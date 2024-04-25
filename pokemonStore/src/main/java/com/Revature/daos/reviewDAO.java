package com.Revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.Revature.models.Review;
import com.Revature.utils.ConnectionFactory;

import java.io.IOException;

public class reviewDAO implements CrudDAO<Review> {

    @Override
    public Review save(Review review){
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO items (id, name, value, grade) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, review.getId());
            ps.setInt(2, review.getRating());
            ps.setString(3, review.getUser_id());
            ps.setString(4, review.getStore_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving review to the database");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return review;
    }

    @Override
    public Review update(Review obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Review delete(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Review> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Review findByID(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }
    public Review findAllReviewByUserID(String ID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }
}
