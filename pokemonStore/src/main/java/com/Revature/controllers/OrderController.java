package com.Revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Revature.dtos.requests.NewOrderRequest;
import com.Revature.dtos.responses.Principal;
import com.Revature.models.CartProduct;
import com.Revature.models.Order;
import com.Revature.services.CartItemService;
import com.Revature.services.CartService;
import com.Revature.services.ItemService;
import com.Revature.services.OrderService;
import com.Revature.services.TokenService;

import io.javalin.http.Context;

public class OrderController {
    private TokenService tokenService;
    private CartService cartService;
    private ItemService itemService;
    private CartItemService cartItemService;
    private OrderService orderService;

    public OrderController() {
    }

    public OrderController(TokenService tokenService, CartService cartService, ItemService itemService, CartItemService cartItemService, OrderService orderService) {
        this.tokenService = tokenService;
        this.cartService = cartService;
        this.itemService = itemService;
        this.cartItemService = cartItemService;
        this.orderService = orderService;
    }

    public void addOrder(Context ctx) {
        Map<String,String> errors = new HashMap<>();
        try {
            String token = ctx.header("auth-token");
            Principal principal = tokenService.parseToken(token);
            NewOrderRequest req = ctx.bodyAsClass(NewOrderRequest.class);
            if (!(principal.getRole().getName().equalsIgnoreCase("ADMIN") || principal.getRole().getName().equalsIgnoreCase("DEFUALT"))) {
                ctx.status(403); // Forbidden
                errors.put("error", "not logged in");
                ctx.json(errors);
                return;
            }
            List<CartProduct> cartProducts = cartItemService.findAllByCartID(cartService.findByID(principal.getId()).getCart_id());
            if (cartProducts.size() == 0) {
                ctx.status(200);
                return;
            } else {
                Order order = new Order();
                order.setUser_id(principal.getId());
                order.setOrder_id(req.getCartId());
                order.setStatus("pending");
                int totalCost = 0;
                
                for (int i = 0; i < cartProducts.size(); i++) {
                    int cost = cartProducts.get(i).getQuantity() * itemService.getItemById(cartProducts.get(i).getItem_id()).getValue();
                    order.getItems().add(itemService.getItemById(cartProducts.get(i).getItem_id()).getName());
                    totalCost += cost;
                }
                order.setCost(totalCost);
                orderService.save(order);
                cartItemService.delete(req.getCartId());
                cartService.delete(req.getCartId());
                ctx.status(200);
                ctx.json(order);
                return;
            }
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }

    public void getOrderHistoryWithUserID(Context ctx) {
        Map<String,String> errors = new HashMap<>();
        try {
            String token = ctx.header("auth-token");
            Principal principal = tokenService.parseToken(token);
            NewOrderRequest req = ctx.bodyAsClass(NewOrderRequest.class);
            if (!(principal.getRole().getName().equalsIgnoreCase("ADMIN") || principal.getRole().getName().equalsIgnoreCase("DEFUALT"))) {
                ctx.status(403); // Forbidden
                errors.put("error", "not logged in");
                ctx.json(errors);
                return;
            }
            List<Order> orders = orderService.getAllByUserID(principal.getId());
            ctx.status(200);
            ctx.json(orders);
            return;
        } catch (Exception e) {
        ctx.status(500);
        e.printStackTrace();
        }
    }

    public void getAllOrderHistory(Context ctx) {
        Map<String,String> errors = new HashMap<>();
        try {
            String token = ctx.header("auth-token");
            Principal principal = tokenService.parseToken(token);
            if (!(principal.getRole().getName().equalsIgnoreCase("ADMIN"))) {
                ctx.status(403); // Forbidden
                errors.put("error", "only Admin can do this");
                ctx.json(errors);
                return;
            }
            List<Order> orders = orderService.getAllOrders();
            ctx.status(200);
            ctx.json(orders);
            return;
        } catch (Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }
}   
