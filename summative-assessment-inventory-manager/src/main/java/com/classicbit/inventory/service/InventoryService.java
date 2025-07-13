package com.classicbit.inventory.service;

import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    // Constructor injection to get repository instance
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // Adds a new item or update an existing one by ID
    public void updateOrAddItem(InventoryItem item) {
        // Validate item
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        String id = item.getProduct().getId();
        InventoryItem existingItem = inventoryRepository.getById(id);

        // Check if item already exists
        if (existingItem != null) {

            // If exists, update quantity and price
            existingItem.setQuantity(item.getQuantity());
            existingItem.setPrice(item.getPrice());

        // Else, add new item
        } else {
            inventoryRepository.add(item);
        }
    }

    public void removeItem(String id) {
        // Delete from repository
        inventoryRepository.delete(id);
    }

    public InventoryItem getItem(String id) {
        // Return item by ID
        return inventoryRepository.getById(id);
    }

    public List<InventoryItem> getAllItems(String id) {
        // Return all items
        return inventoryRepository.getAll();
    }

    public List<InventoryItem> getInStockItems() {
        // Return only in-stock items
        return inventoryRepository.getInStock();
    }

}
