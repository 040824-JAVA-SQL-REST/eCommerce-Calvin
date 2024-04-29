package com.Revature.services;

import com.Revature.daos.CartProductDAO;
import com.Revature.models.CartProduct;
import com.Revature.models.Item;

public class CartItemService {
    private CartProductDAO cartProductDao;

    public CartItemService(CartProductDAO cartProductDao) {
        this.cartProductDao = cartProductDao;
    }

    public CartProduct save(CartProduct obj) {
        return cartProductDao.save(obj);
    }

    public CartProduct update(CartProduct obj) {
        return cartProductDao.update(obj);
    }

    public Item delete(String cartId, String itemId) {
        return cartProductDao.delete(cartId, itemId);
    }
}
