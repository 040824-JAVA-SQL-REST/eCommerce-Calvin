package com.Revature.models;

import java.util.UUID;

public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String role_id;

    public User () {

    }

    public User (String[] data) {
        this.id = data[0];
        this.username = data[1];
        this.password = data[2];
        this.email = data[3];
        this.role_id = data[4];
    }

    public User(String username, String password, String email) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.email = email;
        this.role_id = "DEFAULT";
    }

    public void setUserID(String ID) {
        this.id = ID;
    }

    public String getUserID() {
        return this.id;
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

    public String getRole_id() {
        return this.role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
    public String convertToData() {
        return this.id + "/" + this.username + "/" + this.password + "/" + this.email + "/" + this.role_id;
    }

    @Override
    public String toString() {
        return this.id + "/" + this.username + "/" + this.password + "/" + this.email + "/" + this.role_id;
    }
}
