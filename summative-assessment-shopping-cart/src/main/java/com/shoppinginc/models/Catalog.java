package com.shoppinginc.models;
import com.shoppinginc.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private final Map<String, Item> items;

    // Constructor
    public Catalog() {
        items = new HashMap<>();
        loadCatalog();

    }
    // Catalogue of products
    private void loadCatalog() {
        items.put("Apple", new Item("Apple", 0.99));
        items.put("Banana", new Item("Banana", 0.89));
        items.put("Carrot", new Item("Carrot", 0.99));
        items.put("Lettuce", new Item("Lettuce", 1.39));
        items.put("Milk", new Item("Milk", 2.50));
        items.put("Eggs", new Item("Eggs", 4.50));
        items.put("Bread", new Item("Bread", 2.99));
        items.put("Chicken Breast", new Item("Chicken Breast", 5.99));
        items.put("Ground Beef", new Item("Ground Beef", 6.49));
        items.put("Potato", new Item("Potato", 0.69));
        items.put("Onion", new Item("Onion", 0.89));
        items.put("Cheese", new Item("Cheese", 4.49));
        items.put("Yogurt", new Item("Yogurt", 2.39));
        items.put("Orange Juice", new Item("Orange Juice", 3.79));
        items.put("Rice", new Item("Rice", 2.99));
        items.put("Pasta", new Item("Pasta", 1.49));
        items.put("Tea", new Item("Tea", 3.39));
        items.put("Coffee", new Item("Coffee", 6.79));
        items.put("Butter", new Item("Butter", 3.49));
        items.put("Bacon", new Item("Bacon", 6.99));
        items.put("Frozen Pizza", new Item("Frozen Pizza", 5.49));
        items.put("Ice Cream", new Item("Ice Cream", 5.59));
        items.put("Frozen Vegetables", new Item("Frozen Vegetables", 3.69));
        items.put("Hot Dogs", new Item("Hot Dogs", 4.89));
        items.put("Hot Dog Buns", new Item("Hot Dog Buns", 2.99));
        items.put("Crackers", new Item("Crackers", 2.19));
        items.put("Jelly", new Item("Jelly", 3.49));
        items.put("Peanut Butter", new Item("Peanut Butter", 3.89));
        items.put("Bottled Water", new Item("Bottled Water", 4.89));
        items.put("Cereal", new Item("Cereal", 5.49));
        items.put("Tomato Sauce", new Item("Tomato Sauce", 1.89));
    }

    // Getters
    public Item getItemByName(String name) {
        for (String key : items.keySet()) {
            if (key.equalsIgnoreCase(name)) {
                return items.get(key);
            }
        }
        return null;
    }

    // Display the Catalog
    public void displayCatalog() {
        Utils.print("\n~*~*~*~*~Catalog~*~*~*~*~");
        for (String name : items.keySet()) {
            Item item = items.get(name);
            Utils.print(item.toString());
        }
    }
}
