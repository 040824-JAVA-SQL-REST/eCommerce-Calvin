package com.Revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private String cart_id;
    private List<Item> items;
    private String belongsTo;
    
    public Cart() {

    }

    public Cart(String user_id) {
        this.cart_id = UUID.randomUUID().toString();
        this.items = new ArrayList<Item>();
        this.belongsTo = user_id;
    }

    public String getCart_id() {
        return this.cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getBelongsTo() {
        return this.belongsTo;
    }

    public void setBelongsTo(String belongsTo) {
        this.belongsTo = belongsTo;
    }

}
