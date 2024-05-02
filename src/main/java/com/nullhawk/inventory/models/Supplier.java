package com.nullhawk.inventory.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String contactInfo;
    private String description;

    // TODO: remove comments
    // @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    // private List<Item> items;

    // @ManyToOne
    // @JoinColumn()
    // private ContactInfo contactInfo;
    // @ManyToOne
    // @JoinColumn()
    // private SupplierDescription description;


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