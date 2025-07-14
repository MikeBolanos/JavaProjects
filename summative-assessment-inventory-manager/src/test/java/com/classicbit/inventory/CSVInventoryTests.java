package com.classicbit.inventory;

import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.repository.CsvInventoryRepository;
import com.classicbit.inventory.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = CSVInventoryTests.TestConfig.class)
@TestPropertySource(properties = {
        "inventory.csv.filepath=data/test/inventory-test.csv",
        "inventory.csv.seedpath=data/test/inventory-test-seed.csv"
})
public class CSVInventoryTests {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Value("${inventory.csv.seedpath}")
    private String seedPath;

    @Value("${inventory.csv.filepath}")
    private String testPath;

    @BeforeEach
    void setUp() throws IOException {
        // Reset the test file to the known seed state
        Path seedFile = Paths.get(seedPath);
        Path targetFile = Paths.get(testPath);
        Files.createDirectories(targetFile.getParent()); // Ensure folder exists
        Files.copy(seedFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void canLoadDataFromCsv() {
        List<InventoryItem> items = inventoryRepository.getAll();
        items.forEach(item -> System.out.println(item.getProduct().getId()));
        assertEquals(3, items.size(), "CSV should load exactly 3 items from seed file");
    }

    @Configuration
    static class TestConfig {
        @Bean
        public InventoryRepository inventoryRepository() {
            return new CsvInventoryRepository();
        }
    }
}
