package com.nullhawk.inventory.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;


    private Item item;

    private TransactionType transactionType; // incoming or outgoing
    private Integer quantity;
    private Date transactionDate;

    // Getters and setters
}