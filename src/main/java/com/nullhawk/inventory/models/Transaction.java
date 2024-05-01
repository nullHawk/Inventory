package com.nullhawk.inventory.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Transaction {

    private Long transactionId;


    private Item item;

    private TransactionType transactionType; // incoming or outgoing
    private Integer quantity;
    private Date transactionDate;

    // Getters and setters
}