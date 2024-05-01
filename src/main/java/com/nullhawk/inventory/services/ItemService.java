package com.nullhawk.inventory.services;

import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.Item;
import java.util.List;

public interface ItemService {
    public List<Item> getAllItems();
    public Item getItem(Long id);
    public Item createItem(UserType user,Item item) throws UnauthorizedAccessExcpetion;
    public Item updateItem(UserType user, Long id, Item itemDetails) throws UnauthorizedAccessExcpetion;
    public void deleteItem(UserType user, Long id) throws UnauthorizedAccessExcpetion;
}
