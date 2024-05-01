package com.nullhawk.inventory.controller;

import com.nullhawk.inventory.services.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.nullhawk.inventory.dtos.ItemDto;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.*;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemServiceImp service;

    public ItemController(ItemServiceImp service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<ItemDto> getAllItems() {
        List<Item> items = this.service.getAllItems();
        List<ItemDto> itemDtos = convertToItemDtos(items);
        return itemDtos;
    }

    @GetMapping("/{id}")
    public ItemDto getItem(@PathVariable Long id) {
        Item item = this.service.getItem(id);
        ItemDto itemDto = convertToItemDto(item);
        return itemDto;
    }

    @PostMapping
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        try {
            Item item = convertToItem(itemDto);
            Item createdItem;
            createdItem = this.service.createItem(itemDto.getUser(),item);
            ItemDto createdItemDto = convertToItemDto(createdItem);
            return createdItemDto;
        } catch (UnauthorizedAccessExcpetion e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
        }
    }

    @PutMapping("/{id}")
    public ItemDto updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        try {
            Item item = convertToItem(itemDto);
            Item updatedItem = this.service.updateItem(itemDto.getUser(),id, item);
            return convertToItemDto(updatedItem);
        } catch (UnauthorizedAccessExcpetion e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        try{
            this.service.deleteItem(itemDto.getUser(),id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnauthorizedAccessExcpetion e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
        }
    }

    private Item convertToItem(ItemDto itemDto) {
        Item item = new Item(itemDto.getName(), itemDto.getQuantity(), itemDto.getPrice(), itemDto.getSupplier());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        item.setSupplier(itemDto.getSupplier());
        return item;
    }

    private ItemDto convertToItemDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setPrice(item.getPrice());
        itemDto.setQuantity(item.getQuantity());
        itemDto.setSupplier(item.getSupplier());
        return itemDto;
    }
    private List<ItemDto> convertToItemDtos(List<Item> items) {
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            ItemDto itemDto = convertToItemDto(item);
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
}
