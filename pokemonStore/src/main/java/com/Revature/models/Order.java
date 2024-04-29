package com.Revature.models;

import java.sql.Date;

public class Order {
    String order_id;
    String customer_id;
    Date order_date;
    int cost;

    public Order() {
    }

    public Order(String order_id, String customer_id, Date order_date, int cost) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.cost = cost;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrder_date() {
        return this.order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
}
