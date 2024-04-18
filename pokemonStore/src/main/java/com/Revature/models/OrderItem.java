package com.Revature.models;

public class OrderItem {
    private String order_item_id;
    private String cart_id;
    private String item_id;


    public OrderItem() {

    }

    public OrderItem(String order_item_id, String cart_id, String item_id) {
        this.order_item_id = order_item_id;
        this.cart_id = cart_id;
        this.item_id = item_id;
    }
    
    public String getOrder_item_id() {
        return this.order_item_id;
    }

    public void setOrder_item_id(String order_item_id) {
        this.order_item_id = order_item_id;
    }

    public String getCart_id() {
        return this.cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

}
