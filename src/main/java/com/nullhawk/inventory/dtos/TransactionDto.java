package com.nullhawk.inventory.dtos;

import java.util.Date;

import com.nullhawk.inventory.enums.TransactionType;
import com.nullhawk.inventory.enums.UserType;
// import com.nullhawk.inventory.models.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
    private long id;
    // private Item item;
    private TransactionType transactionType;
    private int amount;
    private Date date;
    private UserType user;
    private ErrorDto error;
}
