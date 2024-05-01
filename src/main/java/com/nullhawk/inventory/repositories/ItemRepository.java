package com.nullhawk.inventory.repositories;

import com.nullhawk.inventory.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    Item save(Item item);
}
