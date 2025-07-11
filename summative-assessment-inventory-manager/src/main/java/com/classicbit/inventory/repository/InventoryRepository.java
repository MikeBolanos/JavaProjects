package com.classicbit.inventory.repository;

import com.classicbit.inventory.InventoryManagerApp;
import com.classicbit.inventory.model.InventoryItem;

import java.util.List;


public interface InventoryRepository {
    List<InventoryItem> getAll();

    List<InventoryItem> getInStock();

    void add(InventoryItem item);

    void update(InventoryItem item);

    void delete(String id);

    InventoryItem getById(String id);
}
