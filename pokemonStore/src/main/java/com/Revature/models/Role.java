package com.Revature.models;

public class Role {
    private String name; 

    public Role() {

    }
    public Role (String name) {
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
