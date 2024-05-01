package com.nullhawk.inventory.models;

import com.nullhawk.inventory.enums.UserType;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private UserType userType;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public String getUsename(){
        return this.username;
    }

}
