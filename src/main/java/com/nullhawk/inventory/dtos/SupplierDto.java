package com.nullhawk.inventory.dtos;

import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.models.ContactInfo;
import com.nullhawk.inventory.models.SupplierDescription;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDto {
    private long id;
    private String name;
    private ContactInfo contactInfo;
    private SupplierDescription description;
    private UserType user;
    private ErrorDto error;
}
