package com.nullhawk.inventory.dtos;

import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.models.Supplier;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    private Long id;
    private String name;
    private int quantity;
    private Supplier supplier;
    private double price;
    private UserType user;
    private ErrorDto error;
}
