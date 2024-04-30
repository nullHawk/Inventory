package com.nullhawk.inventory.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
public class Item {
    private Long itemId;

    private String name;
    private Integer quantity;
    private Double price;




    // Getters and setters
}
