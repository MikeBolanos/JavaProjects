package com.classicbit.inventory.config;


import com.classicbit.inventory.repository.CsvInventoryRepository;
import com.classicbit.inventory.repository.InMemoryInventoryRepository;
import com.classicbit.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryConfig {

    @Value("$(inventory.repository.type:memory}")
    private String repoistoryType;

    @Bean
    public InventoryRepository inventoryRepository() {
        switch (repoistoryType.toLowerCase()) {
            case "csv":
                return new CsvInventoryRepository();
            case "memory":
                return new InMemoryInventoryRepository();
            default:
                throw new IllegalArgumentException(
                        "Invalid repository type: " + repoistoryType +
                        ". Supported types are: 'csv', 'memory'");
        }
    }
}
