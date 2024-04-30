package com.nullhawk.inventory.models;

import java.util.Date;

public class Transaction {

    private Long transactionId;


    private Item item;

    private String transactionType; // incoming or outgoing
    private Integer quantity;
    private Date transactionDate;

    // Getters and setters
}