package com.nullhawk.inventory.models;

import com.nullhawk.inventory.enums.UserType;

import jakarta.persistence.Entity;

@Entity
public class User {
    private UserType userType;
    private String username;
    public User(UserType userType, String username){
        this.userType = userType;
        this.username = username;
    }
    public UserType getUserType() {
        return this.userType;
    }

    public String getUsename(){
        return this.username;
    }

}
