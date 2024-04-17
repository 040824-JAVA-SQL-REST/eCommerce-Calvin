package com.Revature.utils;

import java.util.Scanner;

import com.Revature.services.RouterService;
import com.Revature.services.UserService;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        new RouterService(scan, new UserService())
            .navigate("/start")
            .startInterface();

        scan.close();
    }
}