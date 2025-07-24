package com.example.jdbc.summative;

import com.example.jdbc.summative.data.interfaces.ItemRepo;
import com.example.jdbc.summative.data.exceptions.InternalErrorException;
import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.model.Item;
import com.example.jdbc.summative.model.ItemCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "/sql/reset_db.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

public class MySQLItemRepoTest {
    @Autowired
    private ItemRepo itemRepo;

    @Test
    void testGetItemById_validId() throws Exception {
        Item item = itemRepo.getItemById(1);
        assertNotNull(item);
        assertEquals(1, item.getItemID());
    }

    @Test
    void testGetItemById_invalidId_throwsNotFound() {
        assertThrows(RecordNotFoundException.class, () -> {
            itemRepo.getItemById(9999);
        });
    }

    @Test
    void testGetAllAvailableItems_returnsExpected() throws InternalErrorException {
        LocalDate today = LocalDate.of(2024, 1, 1);
        List<Item> items = itemRepo.getAllAvailableItems(today);
        assertFalse(items.isEmpty());
    }

    @Test
    void testGetItemsByCategory_validCategory() throws InternalErrorException {
        LocalDate today = LocalDate.of(2024, 1, 1);
        int categoryID = 1;
        List<Item> items = itemRepo.getItemsByCategory(today, categoryID);
        assertTrue(items.stream().allMatch(item -> item.getItemCategoryID() == categoryID));
    }

    @Test
    void testGetAllItemCategories() throws InternalErrorException {
        List<ItemCategory> categories = itemRepo.getAllItemCategories();
        assertFalse(categories.isEmpty());
    }
}