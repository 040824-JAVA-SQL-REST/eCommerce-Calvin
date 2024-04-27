package com.Revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Revature.dtos.requests.NewItemRequest;
import com.Revature.dtos.responses.Principal;
import com.Revature.models.Item;
import com.Revature.services.ItemService;
import com.Revature.services.TokenService;

import io.javalin.http.Context;

public class ItemController {
    private ItemService itemService;
    private final TokenService tokenService;
    public ItemController(ItemService itemService, TokenService tokenService) {
        this.itemService = itemService;
        this.tokenService = tokenService;
    }   

    public void addItem(Context ctx) {
        Map<String,String> errors = new HashMap<>();
        try {
            // get token from header
            String token = ctx.header("auth-token");
            if (token == null || token.isEmpty()) {
                ctx.status(401); // unauthorized
                errors.put("error", "token is null or empty");
                ctx.json(errors);
                return;
            }  
            // parse token to get the principal (auth)

            Principal principal = tokenService.parseToken(token);
            if (principal == null) {
                ctx.status(401); // unauthorized
                errors.put("error", "principal is null");
                ctx.json(errors);
                return;
            }

            if (!principal.getRole().getName().equalsIgnoreCase("ADMIN")) {
                ctx.status(403); // forbiddon
                errors.put("error", principal.getRole().getName());
                ctx.json(errors);
                return;
            }
            
            NewItemRequest req = ctx.bodyAsClass(NewItemRequest.class);
            if (req.getName().isEmpty()) {
                ctx.status(400);
                errors.put("error", "Your item needs a name!");
                ctx.json(errors);
                return;
            }
            if (req.getStore_id().isEmpty()) {
                ctx.status(400);
                errors.put("error", "Your item needs a store!");
                ctx.json(errors);
                return;
            }
            if(!itemService.isUnique(req.getName())) {
                ctx.status(409);
                errors.put("error", "item already exists or item name already taken");
                ctx.json(errors);
                return;
            }
            itemService.createItem(req.getName(), req.getValue(), req.getGrade(), req.getStore_id());
        } catch(Exception e) {
            ctx.status(500);
            e.printStackTrace();
        }
    }
    
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
