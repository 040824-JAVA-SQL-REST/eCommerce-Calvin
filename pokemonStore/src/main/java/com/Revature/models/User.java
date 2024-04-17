package com.Revature.models;

import java.util.UUID;

public class User {
    private String user_id;
    private String username;
    private String password;
    private String email;
    private String role_id;

    public User () {

    }

    public User(String username, String password, String email) {
        this.user_id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.email = email;
        this.role_id = "DEFAULT";
    }

    public void setUserID(String ID) {
        this.user_id = ID;
    }

    public String getUserID() {
        return this.user_id;
    }

    public void setUsername(String usernmae) {
        this.username = usernmae;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole_id() {
        return this.role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

}
