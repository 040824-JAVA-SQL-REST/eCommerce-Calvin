package com.Revature.models;

public class OrderItem {
    private String order_id;
    private String item_id;
    private int quantity;

    public OrderItem() {

    }

    public OrderItem(String order_id, String item_id, int quantity) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrderId(String order_id) {
        this.order_id = order_id;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
