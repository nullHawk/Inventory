package com.nullhawk.inventory.controller;

import com.nullhawk.inventory.services.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemServiceImp service;

    public ItemController(ItemServiceImp service) {
        this.service = service;
    }

//    @GetMapping({"/allitems")
//    public List<Item> getAllItems() {
//        return itemService.getAllItems();  implement getAllItems
//    }

//    @GetMapping("/{id}")
//    public Item getItem(@PathVariable Long id) {
//        return itemService.getItem(id);
//    }

//    @PostMapping
//    public Item createItem(@RequestBody Item item) {
//        return itemService.createItem(item);
//    }

//    @PutMapping("/{id}")
//    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
//        return itemService.updateItem(id, item);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteItem(@PathVariable Long id) {
//        itemService.deleteItem(id);
//    }
}
