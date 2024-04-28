package com.Revature.controllers;

import java.util.HashMap;
import java.util.Map;

import com.Revature.dtos.requests.AddCartItemRequest;
import com.Revature.dtos.responses.Principal;
import com.Revature.models.Cart;
import com.Revature.models.Item;
import com.Revature.services.CartService;
import com.Revature.services.ItemService;
import com.Revature.services.TokenService;
import com.Revature.services.UserService;

import io.javalin.http.Context;

public class CartController {
    private TokenService tokenService;
    private CartService cartService;
    private ItemService itemService;


    public CartController(TokenService tokenService, CartService cartService, ItemService itemService) {
        this.tokenService = tokenService;
        this.cartService = cartService;
        this.itemService = itemService;
    }
    
    public void addItem(Context ctx) {
        Map<String,String> errors = new HashMap<>();
        try {
            String token = ctx.header("auth-token");
            
            // Authenticate user
            Principal principal = tokenService.parseToken(token);
            if (principal == null) {
                ctx.status(401); // Unauthorized
                errors.put("error", "null user");
                return;
            }
            
            AddCartItemRequest req = ctx.bodyAsClass(AddCartItemRequest.class);
            
            
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }
}
