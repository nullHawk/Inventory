package com.nullhawk.inventory.services;

import com.nullhawk.inventory.Exceptions.ItemNotFoundException;
import com.nullhawk.inventory.Repositories.ItemRepository;
import com.nullhawk.inventory.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemService {
    @Autowired
    private ItemRepository itemRepository;

    public itemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
//
//    public List<Item> getAllItems() {
//        return itemRepository.findAll();
//    }
//
//    public Item getItem(Long id) {
//        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found"));
//    }
//
//    public Item createItem(Item item) {
//        return itemRepository.save(item);
//    }
//
//    public Item updateItem(Long id, Item itemDetails) {
//        Item item = getItem(id);
//        item.setName(itemDetails.getName());
//        item.setQuantity(itemDetails.getQuantity());
//        item.setPrice(itemDetails.getPrice());
//        return itemRepository.save(item);
//    }
//
//    public void deleteItem(Long id) {
//        Item item = getItem(id);
//        itemRepository.delete(item);
//    }
}
