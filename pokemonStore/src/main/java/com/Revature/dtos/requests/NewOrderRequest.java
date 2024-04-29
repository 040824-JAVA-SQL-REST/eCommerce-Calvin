package com.Revature.dtos.requests;

public class NewOrderRequest {
    private String userID;
    private String cartID;
    private String itemID;
    private int quantity;


    public NewOrderRequest() {
    }

    public NewOrderRequest(String userID, String cartID, String itemID, int quantity) {
        this.userID = userID;
        this.cartID = cartID;
        this.itemID = itemID;
        this.quantity = quantity;
    }

    public String getCartId() {
        return this.cartID;
    }

    public void setCartID(String cartId) {
        this.cartID = cartId;
    }

    public String getItemID() {
        return this.itemID;
    }

    public void setItemID(String itemId) {
        this.itemID = itemId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
