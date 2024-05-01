package com.nullhawk.inventory.models;


import java.util.Date;

import com.nullhawk.inventory.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Item item;
    private TransactionType transactionType;
    private int amount;
    private Date date;
    // public long getId() {
    //     return id;
    // }

    // public Item getItem() {
    //     return item;
    // }

    // public void setItem(User user, Item item)throws UnauthorizedAccessExcpetion{
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.item = item;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }

    // public TransactionType getTransactionType() {
    //     return transactionType;
    // }

    // public void setTransactionType(User user, TransactionType transactionType)throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.transactionType = transactionType;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }

    // public int getAmount() {
    //     return amount;
    // }

    // public void setQuantity(User user, int quantity)throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.amount = quantity;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }

    // public Date getDate() {
    //     return date;
    // }

    // public void setDate(User user, Date date) throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.date = date;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }
}