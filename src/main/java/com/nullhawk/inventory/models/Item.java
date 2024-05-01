package com.nullhawk.inventory.models;

import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Item {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;
    private double price;
    private Supplier supplier;

    public Item(String name, int quantity, double price, Supplier supplier){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(User user, int quantity) throws UnauthorizedAccessExcpetion {
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.quantity = quantity;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(User user, double price) throws UnauthorizedAccessExcpetion {
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.price = price;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(User user, Supplier supplier) throws UnauthorizedAccessExcpetion {
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.supplier = supplier;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }
}
