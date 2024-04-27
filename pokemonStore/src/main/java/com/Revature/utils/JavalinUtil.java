package com.Revature.utils;

import java.io.IOException;
import java.sql.SQLException;

import com.Revature.controllers.ItemController;
import com.Revature.controllers.StoreController;
import com.Revature.controllers.UserController;
import com.Revature.daos.CartDAO;
import com.Revature.daos.RoleDAO;
import com.Revature.daos.StoreDAO;
import com.Revature.daos.UserDAO;
import com.Revature.services.CartService;
import com.Revature.services.ItemService;
import com.Revature.services.RoleService;
import com.Revature.services.StoreService;
import com.Revature.services.TokenService;
import com.Revature.services.UserService;

import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.Javalin;

public class JavalinUtil {

    public Javalin getJavalin() throws IOException {
        // Controllers
        UserController userController = new UserController(
            getUserService(),
            new CartService(
            new CartDAO()),
            new TokenService());
        StoreController storeController = new StoreController (
            new StoreService(new StoreDAO()),
            new TokenService()
        );
        return Javalin.create(config -> {
            config.router.apiBuilder(() -> {
                path("/users", () -> {
                    post("/register", userController::register);
                    post("/login", userController::login);
                    delete(userController::delete);
                });

                path("/stores", () -> {
                    post(storeController::addStore);
                    get(storeController::getAllStores);
                });
            });
        });
    }

    private UserService getUserService() {
        return new UserService(new UserDAO(), new RoleService(new RoleDAO()));
    }

    private StoreService getStoreService() {
        return new StoreService(new StoreDAO());
    }
}