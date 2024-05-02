package com.nullhawk.inventory.dtos;

import com.nullhawk.inventory.enums.UserType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDto {
    private long id;
    private String name;
    private String contactInfo;
    private String description;
    private UserType user;
    private ErrorDto error;
}
