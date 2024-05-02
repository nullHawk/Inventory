package com.nullhawk.inventory.services;

import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.ItemNotFoundException;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.Item;
import com.nullhawk.inventory.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ItemServiceImp implements ItemService{
    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImp.class);

    @Autowired
    private ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItem(Long id) {
        logger.info("Getting all items");
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }

    @Override
    public Item createItem(UserType user, Item item) throws UnauthorizedAccessExcpetion {
        logger.info("creating item");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            return itemRepository.save(item);
        }else{
            logger.error("Not authorized to create item");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    @Override
    public Item updateItem(UserType user, Long id, Item itemDetails) throws UnauthorizedAccessExcpetion {
        logger.info("updating item");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            Item item = getItem(id);
            item.setName(itemDetails.getName());
            item.setQuantity(itemDetails.getQuantity());
            item.setPrice(itemDetails.getPrice());
            return itemRepository.save(item);
        }else{
            logger.error("Not authorized to update item");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    @Override
    public void deleteItem(UserType user, Long id) throws UnauthorizedAccessExcpetion {
        logger.info("deleting item");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            Item item = getItem(id);

            itemRepository.delete(item);
            logger.info("Item deleted");
        }else{
            logger.error("Not authorized to delete item");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }
}
