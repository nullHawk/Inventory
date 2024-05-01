package com.nullhawk.inventory.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity
public class Item {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;
    private double price;
    @OneToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @OneToMany
    private List<Transaction> transactions;


    // public long getId() {
    //     return id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(User user, String name) throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.name = name;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }

    // public int getQuantity() {
    //     return quantity;
    // }

    // public void setQuantity(User user, int quantity) throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.quantity = quantity;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }

    // public double getPrice() {
    //     return price;
    // }

    // public void setPrice(User user, double price) throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.price = price;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }

    // public Supplier getSupplier() {
    //     return supplier;
    // }

    // public void setSupplier(User user, Supplier supplier) throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.supplier = supplier;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }
}
