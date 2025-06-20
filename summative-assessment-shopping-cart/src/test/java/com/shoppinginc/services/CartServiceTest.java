package com.shoppinginc.services;
import com.shoppinginc.models.*;
import org.junit.jupiter.api.Test;

public class CartServiceTest {
    @Test
    public void testAddItem() {
        // Arrange
        Catalog catalog = new Catalog();
        CartService cartService = new CartService(catalog);
        Item milk = catalog.getItemByName("Milk");

        // Act
        
        // Assert
    }
}
