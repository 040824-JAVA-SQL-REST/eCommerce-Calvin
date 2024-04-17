package com.Revature.services;

public class UserService {
    
    public boolean isUnique(String username) {
        //TODO
        return true;
    }

    public boolean validPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
