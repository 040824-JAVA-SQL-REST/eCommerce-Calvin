package com.Revature.controllers;

import com.Revature.services.ItemService;
import com.Revature.services.UserService;

public class ItemController {
    private ItemService itemService;
    private UserService userService;
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }   

    

}
