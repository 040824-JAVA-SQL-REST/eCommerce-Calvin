package com.Revature.services;

import com.Revature.daos.CartDAO;
import com.Revature.models.Cart;
import com.Revature.models.User;

public class CartService {
    private CartDAO cartDAO;
    
    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public Cart save(Cart cart, User user) {
        cart.setBelongsTo(user.getId());
        return cartDAO.save(cart);
    }
}
