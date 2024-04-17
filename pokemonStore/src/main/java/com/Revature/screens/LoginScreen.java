package com.Revature.screens;

import java.util.Scanner;

import com.Revature.services.RouterService;

public class LoginScreen extends BaseScreen{
    private Scanner scan;
    private RouterService routerService;

    public LoginScreen(RouterService routerService, Scanner scan) {
        this.scan = scan;
        this.routerService = routerService;
    }
    @Override
    public void startInterface() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startInterface'");
    }
    
}
