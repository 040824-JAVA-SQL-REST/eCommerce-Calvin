package com.Revature.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.Revature.daos.RoleDAO;
import com.Revature.daos.UserDAO;
import com.Revature.services.RoleService;
import com.Revature.services.RouterService;
import com.Revature.services.UserService;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Scanner scan = new Scanner(System.in);
        

        // System.out.println(ConnectionFactory.getInstance().getConnection());
        // scan.nextLine();
        
        new RouterService(scan, new UserService(new UserDAO(), new RoleService(new RoleDAO())))
            .navigate("/start")
            .startInterface();
        scan.close();
    }
}