package com.nullhawk.inventory.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
public class Supplier {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn()
    private ContactInfo contactInfo;
    @ManyToOne
    @JoinColumn()
    private SupplierDescription description;


    // public long getId() {
    //     return id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(User user, String name) throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.name = name;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }

    // public ContactInfo getContactInfo() {
    //     return contactInfo;
    // }

    // public void setContactInfo(User user, ContactInfo contactInfo) throws UnauthorizedAccessExcpetion {
    //     if(user.getUserType() == UserType.ADMIN || user.getUserType() == UserType.MANAGER){
    //         this.contactInfo = contactInfo;
    //     }else{
    //         throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
    //     }
    // }

    // public Description getDescription() {
    //     return description;
    // }

    // public void setDescription(SupplierDescription description) {
    //     this.description = description;
    // }

}