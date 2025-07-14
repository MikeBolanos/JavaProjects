package com.classicbit.inventory;

import com.classicbit.inventory.model.Console;
import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.repository.InMemoryInventoryRepository;
import com.classicbit.inventory.repository.InventoryRepository;
import com.classicbit.inventory.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryServiceTests {
    private InventoryService inventoryService;
    private InventoryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryInventoryRepository();
        inventoryService = new InventoryService(repository);
    }

    @Test
    void testGetItemById() {
        InventoryItem item = inventoryService.getItem("NES");
        assertNotNull(item);
        assertEquals("NES", item.getProduct().getId());
    }

    @Test
    void testGetAllItems() {
        List<InventoryItem> items = inventoryService.getAllItems();
        assertFalse(items.isEmpty());
        assertTrue(items.size() >= 10); // depends on your sample data
    }

    @Test
    void testUpdateOrAddItem_NewItem() {
        Console console = new Console("NEW", "New Console", "NewCorp", "2025", "Region-Free");
        InventoryItem newItem = new InventoryItem(console, 3, new BigDecimal("199.99"));
        inventoryService.updateOrAddItem(newItem);

        InventoryItem result = inventoryService.getItem("NEW");
        assertNotNull(result);
        assertEquals(3, result.getQuantity());
        assertEquals(new BigDecimal("199.99"), result.getPrice());
    }

    @Test
    void testUpdateOrAddItem_UpdateExisting() {
        InventoryItem item = inventoryService.getItem("NES");
        assertNotNull(item);

        int newQuantity = 10;
        BigDecimal newPrice = new BigDecimal("149.99");

        item.setQuantity(newQuantity);
        item.setPrice(newPrice);
        inventoryService.updateOrAddItem(item);

        InventoryItem updated = inventoryService.getItem("NES");
        assertEquals(newQuantity, updated.getQuantity());
        assertEquals(newPrice, updated.getPrice());
    }

    @Test
    void testRemoveItem() {
        inventoryService.removeItem("SNES");
        assertNull(inventoryService.getItem("SNES"));
    }

    @Test
    void testGetInStockItems() {
        List<InventoryItem> inStock = inventoryService.getInStockItems();
        assertFalse(inStock.isEmpty());
        assertTrue(inStock.stream().allMatch(item -> item.getQuantity() > 0));
    }
}
