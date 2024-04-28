package com.Revature.utils;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import java.io.IOException;

import com.Revature.controllers.ItemController;
import com.Revature.controllers.StoreController;
import com.Revature.controllers.UserController;
import com.Revature.daos.CartDAO;
import com.Revature.daos.ItemDAO;
import com.Revature.daos.RoleDAO;
import com.Revature.daos.StoreDAO;
import com.Revature.daos.UserDAO;
import com.Revature.services.CartService;
import com.Revature.services.ItemService;
import com.Revature.services.RoleService;
import com.Revature.services.StoreService;
import com.Revature.services.TokenService;
import com.Revature.services.UserService;

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
        ItemController itemController = new ItemController(
            new ItemService(new ItemDAO()), 
            new TokenService(), 
            getStoreService());
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

                path("/items", () -> {
                    post(itemController::addItem);
                    delete(itemController::delete);
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