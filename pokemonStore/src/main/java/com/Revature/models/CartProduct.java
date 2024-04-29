package com.Revature.models;

public class CartProduct {
    private String item_id;
    private String store_id;
    private int quantity;

    public CartProduct() {
    }

    public CartProduct(String item_id, String store_id, int quantity) {
        this.item_id = item_id;
        this.store_id = store_id;
        this.quantity = quantity;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getStore_id() {
        return this.store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }
    

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

}
