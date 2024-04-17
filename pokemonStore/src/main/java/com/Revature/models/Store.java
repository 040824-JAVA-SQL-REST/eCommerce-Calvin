package com.Revature.models;
import java.util.UUID;

public class Store {
    private String store_id;
    private String name;
    private double rating;

    public Store() {
    }

    public Store(String name) {
        this.store_id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getStore_id() {
        return this.store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}