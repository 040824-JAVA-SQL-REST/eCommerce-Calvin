package com.Revature.controllers;

import java.util.HashMap;
import java.util.Optional;

import com.Revature.dtos.requests.NewLoginRequest;
import com.Revature.dtos.requests.NewRegisterRequest;
import com.Revature.dtos.responses.Principle;
import com.Revature.models.Cart;
import com.Revature.models.User;
import com.Revature.services.CartService;
import com.Revature.services.UserService;

import io.javalin.http.Context;

public class UserController {
    private UserService userService;
    private CartService cartService;

    public UserController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    public void register(Context ctx) {
        HashMap<String, String> errors = new HashMap<>();
        try {
            NewRegisterRequest req = ctx.bodyAsClass(NewRegisterRequest.class);

            if (!userService.isValidUsername(req.getUsername())) {
                ctx.status(400);
                errors.put("Error:", "Username is not valid");
                return;
            } if (!userService.uniqueUsername(req.getUsername())) {
                ctx.status(409);
                errors.put("Error:", "Username is not unique");
                return;
            } if (!userService.validPassword(req.getPassword())) {
                ctx.status(400);
                errors.put("Error:", "Username is not valid");
                return;
            }
            User newUser = new User(req);
            Cart newCart = new Cart(newUser.getId());
            newUser.setCartID(newCart.getCart_id());
            newUser = userService.save(newUser);
            newCart = cartService.save(newCart, newUser);
            // create json web token week3 day 2
            ctx.status(200);
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }
    public void login(Context ctx) {
        HashMap<String, String> errors = new HashMap<>();
        try {
            NewLoginRequest req = ctx.bodyAsClass(NewLoginRequest.class);
            Optional<User> existingUser = userService.login(req.getUsername(), req.getPassword());
            if (existingUser.isEmpty()) {
                ctx.status(400);
                errors.put("Error:", "Invalid username or password");
                return;
            }
            User foundUser = existingUser.get();
            Principle principle = new Principle(foundUser);
            System.out.println(foundUser.toString());
            ctx.json(principle);
            ctx.status(200);
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }
    
}
