package com.Revature.dtos.requests;

public class NewItemRequest {
    private String name;
    private int value;
    private int grade;
    private String store_id;
    public NewItemRequest() {
    }
    
    public NewItemRequest(String name, int value, int grade, String store_id) {
        this.name = name;
        this.value = value;
        this.grade = grade;
        this.store_id = store_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getStore_id() {
        return this.store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

}   
