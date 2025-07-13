package com.classicbit.inventory.repository;

import com.classicbit.inventory.model.Console;
import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.model.Product;
import com.classicbit.inventory.model.RareConsole;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvInventoryRepository implements InventoryRepository {

    private final Map<String, InventoryItem> inventory = new HashMap<>();
    @Value("${inventory.csv.filepath:data/inventory.csv}")
    private String filename;

    @PostConstruct
    public void init() {
        loadFromFile();
    }

    @Override
    public List<InventoryItem> getAll() {
        return new ArrayList<>(inventory.values());
    }

    @Override
    public List<InventoryItem> getInStock() {
        return inventory.values().stream()
                .filter(item -> item.getQuantity() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public void add(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        inventory.put(item.getConsole().getId(), item);
        saveToFile();
    }

    @Override
    public void update(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        String id = item.getConsole().getId();
        if (!inventory.containsKey(id)) {
            throw new IllegalArgumentException("Item with ID " + id + " not found");
        }
        inventory.put(id, item);
        saveToFile();
    }

    @Override
    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        inventory.remove(id);
        saveToFile();
    }

    @Override
    public InventoryItem getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return inventory.get(id);
    }

    private void loadFromFile() {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                Product product;
                InventoryItem item;

                if (parts[0].equalsIgnoreCase("Rare")) {
                    String id = parts[1].trim();
                    String name = parts[2].trim();
                    String manufacturer = parts[3].trim();
                    String releaseYear = parts[4].trim();
                    String regionLock = parts[5].trim();
                    String rarity = parts[6].trim();
                    String certificate = parts[7].trim();
                    int quantity = Integer.parseInt(parts[8].trim());
                    BigDecimal price = new BigDecimal(parts[9].trim());

                    Console base = new Console(id, name, manufacturer, releaseYear, regionLock);
                    product = new RareConsole(base, rarity, certificate);
                    item = new InventoryItem(product, quantity, price);
                } else {

                        String id = parts[0].trim();
                        String name = parts[1].trim();
                        String manufacturer = parts[2].trim();
                        String releaseYear = parts[3].trim();
                        String region = parts[4].trim();
                        int quantity = Integer.parseInt(parts[5].trim());
                        BigDecimal price = new BigDecimal(parts[6].trim());

                        product = new Console(id, name, manufacturer, releaseYear, region);
                        item = new InventoryItem(product, quantity, price);
                }
                inventory.put(product.getId(), item);

            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + filename, e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error parsing number from file: " + filename, e);
        }
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (InventoryItem item : inventory.values()) {
                Product product = item.getConsole();

                if (product instanceof RareConsole rare) {
                    Console base = rare.getBaseConsole();
                    writer.printf("Rare,%s,%s,%s,%s,%s,%s,%s,%d,%.2f%n",
                            base.id(),
                            base.name(),
                            base.manufacturer(),
                            base.releaseYear(),
                            base.regionLock(),
                            rare.rarity(),
                            rare.certificate(),
                            item.getQuantity(),
                            item.getPrice());
                } else if (product instanceof Console console) {
                    writer.printf("%s,%s,%s,%s,%s,%d,%.2f%n",
                            console.id(),
                            console.name(),
                            console.manufacturer(),
                            console.releaseYear(),
                            console.regionLock(),
                            item.getQuantity(),
                            item.getPrice());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filename, e);
        }
    }
}
