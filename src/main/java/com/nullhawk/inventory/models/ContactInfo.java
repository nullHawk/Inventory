package com.nullhawk.inventory.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ContactInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public ContactInfo(String firstName, String lastName, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
