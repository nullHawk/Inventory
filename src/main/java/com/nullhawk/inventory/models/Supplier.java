package com.nullhawk.inventory.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Supplier {

    private Long supplierId;

    private String name;
    private ContactInfo contactInformation;
    private String description;


    // Getters and setters
}