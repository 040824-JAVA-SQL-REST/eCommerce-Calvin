package com.Revature.controllers;

import java.util.HashMap;
import java.util.Map;

import com.Revature.dtos.requests.AddCartItemRequest;
import com.Revature.dtos.requests.GetCartRequest;
import com.Revature.dtos.responses.Principal;
import com.Revature.models.CartProduct;
import com.Revature.services.CartItemService;
import com.Revature.services.CartService;
import com.Revature.services.ItemService;
import com.Revature.services.TokenService;

import io.javalin.http.Context;

public class CartItemController {
    private final TokenService tokenService;
    private CartService cartService;
    private ItemService itemService;
    private CartItemService cartItemService;


    public CartItemController(TokenService tokenService, CartService cartService, ItemService itemService, CartItemService cartItemService) {
        this.tokenService = tokenService;
        this.cartService = cartService;
        this.itemService = itemService;
        this.cartItemService = cartItemService;
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
                ctx.json(errors);
                return;
            }

            AddCartItemRequest req = ctx.bodyAsClass(AddCartItemRequest.class);
            if (req.getItemId() == null) {
                ctx.status(400);
                errors.put("error", "item id is null");
                ctx.json(errors);
                return;
            }
            if (itemService.getItemById(req.getItemId()) == null) {
                ctx.status(404); // not found
                errors.put("error", "item not found");
                ctx.json(errors);

                return;
            }
            if (req.getCartId() == null) {
                ctx.status(400);
                errors.put("error", "cart id is null");
                ctx.json(errors);

                return;
            }
            if (cartService.findByCartID(req.getCartId()) == null) {
                ctx.status(404);
                errors.put("error", "no cart with that id");
                ctx.json(errors);

                return;
            }
            cartItemService.save(new CartProduct(req.getItemId(), req.getCartId(), req.getQuantity()));
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }

    public void updateQuantity(Context ctx) {
        Map<String,String> errors = new HashMap<>();
        try {
            String token = ctx.header("auth-token");
            // Authenticate user
            Principal principal = tokenService.parseToken(token);
            if (principal == null) {
                ctx.status(401); // Unauthorized
                errors.put("error", "null user");
                ctx.json(errors);
                return;
            }

            AddCartItemRequest req = ctx.bodyAsClass(AddCartItemRequest.class);
            if (req.getItemId() == null) {
                ctx.status(400);
                errors.put("error", "item id is null");
                ctx.json(errors);
                return;
            }
            if (itemService.getItemById(req.getItemId()) == null) {
                ctx.status(404); // not found
                errors.put("error", "item not found");
                ctx.json(errors);

                return;
            }
            if (req.getCartId() == null) {
                ctx.status(400);
                errors.put("error", "cart id is null");
                ctx.json(errors);

                return;
            }
            if (cartService.findByCartID(req.getCartId()) == null) {
                ctx.status(404);
                errors.put("error", "no cart with that id");
                ctx.json(errors);
                return;
            }
            cartItemService.update(new CartProduct(req.getItemId(), req.getCartId(), req.getQuantity()));
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }

    public void delete(Context ctx) {
        Map<String,String> errors = new HashMap<>();
        try {
            String token = ctx.header("auth-token");
            
            // Authenticate user
            Principal principal = tokenService.parseToken(token);
            if (principal == null) {
                ctx.status(401); // Unauthorized
                errors.put("error", "null user");
                ctx.json(errors);
                return;
            }

            AddCartItemRequest req = ctx.bodyAsClass(AddCartItemRequest.class);
            if (req.getItemId() == null) {
                ctx.status(400);
                errors.put("error", "item id is null");
                ctx.json(errors);
                return;
            }
            if (itemService.getItemById(req.getItemId()) == null) {
                ctx.status(404); // not found
                errors.put("error", "item not found");
                ctx.json(errors);

                return;
            }
            if (req.getCartId() == null) {
                ctx.status(400);
                errors.put("error", "cart id is null");
                ctx.json(errors);

                return;
            }
            if (cartService.findByCartID(req.getCartId()) == null) {
                ctx.status(404);
                errors.put("error", "no cart with that id");
                ctx.json(errors);

                return;
            }
            cartItemService.delete(req.getCartId(), req.getItemId());
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }

    public void getUserCart(Context ctx) {
        Map<String,String> errors = new HashMap<>();
        try {
            String token = ctx.header("auth-token");
            
            // Authenticate user
            Principal principal = tokenService.parseToken(token);
            if (principal == null) {
                ctx.status(401); // Unauthorized
                errors.put("error", "null user");
                ctx.json(errors);
                return;
            }

            GetCartRequest req = ctx.bodyAsClass(GetCartRequest.class);
            if (req.getCart_id() == null) {
                ctx.status(400);
                errors.put("error", "cart_id is null");
                ctx.json(errors);
                return;
            }
            if (req.getUser_id() == null) {
                ctx.status(404); // not found
                errors.put("error", "user_id is null");
                ctx.json(errors);
                return;
            }
            ctx.json(cartItemService.findAllByCartID(req.getCart_id()));
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }
}
