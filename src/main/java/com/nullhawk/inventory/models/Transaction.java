package com.nullhawk.inventory.models;

import java.util.Date;

import com.nullhawk.inventory.enums.TransactionType;
import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;

import jakarta.persistence.Entity;

@Entity
public class Transaction {
    private long id;
    private Item item;
    private TransactionType transactionType;
    private int quantity;
    private Date date;
    
    public Transaction(long id, Item item, TransactionType transactionType, int quantity, Date date){
        this.item = item;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.date = date;
    }
    public long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(User user, Item item)throws UnauthorizedAccessExcpetion{
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.item = item;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(User user, TransactionType transactionType)throws UnauthorizedAccessExcpetion {
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.transactionType = transactionType;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(User user, int quantity)throws UnauthorizedAccessExcpetion {
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.quantity = quantity;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(User user, Date date) throws UnauthorizedAccessExcpetion {
        if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
            this.date = date;
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }
}