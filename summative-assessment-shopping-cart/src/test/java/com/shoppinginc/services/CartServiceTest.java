package com.shoppinginc.services;

import com.shoppinginc.models.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class CartServiceTest {
    @Test
    public void testAddItem() {
        // Arrange
        Catalog catalog = new Catalog();
        CartService cartService = new CartService(catalog);
        Item milk = catalog.getItemByName("Milk");

        // Act
        cartService.addItem(milk, 2);
        cartService.addItem(milk, 6);
        // Assert
        int quantity = cartService.getCartQuantity("Milk");
        assertEquals(8,quantity);

    }

    @Test
    public void testRemoveFullItem() {
        Catalog catalog = new Catalog();
        CartService cartService = new CartService(catalog);
        Item apple = catalog.getItemByName("Apple");

        cartService.addItem(apple, 5);
        cartService.removeItem("Apple", 5);

        int remainder = cartService.getCartQuantity("Apple");
        assertEquals(0, remainder);
    }

}

