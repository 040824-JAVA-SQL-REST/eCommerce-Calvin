package com.Revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.models.Order;
import com.Revature.utils.ConnectionFactory;

public class OrderDAO {

    // Method to insert a new order into the database
    public Order addOrder(Order order) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO orders (order_id, customer_id, order_date, cost) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, order.getOrder_id());
            ps.setString(2, order.getCustomer_id());
            ps.setDate(3, order.getOrder_date());
            ps.setInt(4, order.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return order;
    }

    // Method to retrieve all orders from the database
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders");
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Order order = new Order();
                order.setCustomer_id(rs.getString("order_id"));
                order.setOrder_id(rs.getString("customer_id"));
                order.setOrder_date(rs.getDate("order_date"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return orders;
    }

    // Method to retrieve an order by its ID
    public Order getOrderById(int orderId) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders WHERE order_id = ?")) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Order order = new Order();
                    order.setOrder_id(rs.getString("order_id"));
                    order.setCustomer_id(rs.getString("customer_id"));
                    order.setOrder_date(rs.getDate("order_date"));
                    return order; // Return the Order object if found
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return null; // Order not found
    }

    // Method to update an existing order in the database
    public Order updateOrder(Order order) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE orders SET customer_id = ?, order_date = ? WHERE order_id = ?")) {
            ps.setString(1, order.getCustomer_id());
            ps.setDate(2, order.getOrder_date());
            ps.setString(3, order.getOrder_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return order;
    }

    // Method to delete an order from the database
    public Order deleteOrder(String orderId) {
        Order deletedOrder = null;
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM orders WHERE order_id = ?")) {
            ps.setString(1, orderId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                deletedOrder = new Order();
                deletedOrder.setOrder_id(orderId);                
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties file");
        }
        return deletedOrder;
    }
}
