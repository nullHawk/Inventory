package com.nullhawk.inventory.models;


import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supplier {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private ContactInfo contactInfo;
    private SupplierDescription description;

    public Supplier(String name, ContactInfo contactInfo, SupplierDescription description){
        this.id = 0;
        this.name = name;
        this.contactInfo = contactInfo;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(User user, String name) throws UnauthorizedAccessExcpetion {
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.name = name;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(User user, ContactInfo contactInfo) throws UnauthorizedAccessExcpetion {
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.contactInfo = contactInfo;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(SupplierDescription description) {
        this.description = description;
    }

}