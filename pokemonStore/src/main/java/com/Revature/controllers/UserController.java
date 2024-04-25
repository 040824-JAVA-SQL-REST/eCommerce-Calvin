package com.Revature.controllers;

import io.javalin.http.Context;

public class UserController {
    public void register(Context ctx) {
        ctx.result("REGISTER");
    }
    public void login(Context ctx) {
        ctx.result("LOGIN");
    }
    
}
