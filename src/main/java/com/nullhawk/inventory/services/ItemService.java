package com.nullhawk.inventory.services;

import com.nullhawk.inventory.models.Item;

import java.util.List;

public interface ItemService {
    public List<Item> getAllItems();
    public Item getItem(Long id);
    public Item createItem(Item item);
    public Item updateItem(Long id, Item itemDetails);
    public void deleteItem(Long id);
}
