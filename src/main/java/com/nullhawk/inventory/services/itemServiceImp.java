package com.nullhawk.inventory.services;

import com.nullhawk.inventory.exceptions.ItemNotFoundException;
import com.nullhawk.inventory.models.Item;
import com.nullhawk.inventory.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemServiceImp implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    public itemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
//
    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }
//
    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item itemDetails) {
        Item item = getItem(id);
        item.setName(itemDetails.getName());
        item.setQuantity(itemDetails.getQuantity());
        item.setPrice(itemDetails.getPrice());
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = getItem(id);
        itemRepository.delete(item);
    }
}
