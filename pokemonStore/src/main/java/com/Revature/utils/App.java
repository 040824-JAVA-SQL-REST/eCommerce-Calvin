package com.Revature.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.Revature.controllers.UserController;
import com.Revature.daos.CartDAO;
import com.Revature.daos.RoleDAO;
import com.Revature.daos.StoreDAO;
import com.Revature.daos.UserDAO;
import com.Revature.models.User;
import com.Revature.services.CartService;
import com.Revature.services.RoleService;
import com.Revature.services.RouterService;
import com.Revature.services.StoreService;
import com.Revature.services.UserService;

import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        // Scanner scan = new Scanner(System.in);
        // User session = new User();
        
        // new RouterService(scan, new App().getUserService(), session)
        //     .navigate("/start")
        //     .startInterface();
        // scan.close();
        App app = new App();
        UserController userController = new UserController(new UserService(new UserDAO(), new RoleService(new RoleDAO())), new CartService(new CartDAO()));

        Javalin.create(config -> {
            config.router.apiBuilder(() -> {
                path("/users", () -> {
                    post("/register", userController::register);
                    post("/login", userController::login);
                });
            });
        }).start(7070);
    }

    private UserService getUserService() {
        return new UserService(new UserDAO(), new RoleService(new RoleDAO()));
    }

    private StoreService getStoreService() {
        return new StoreService(new StoreDAO());
    }
}