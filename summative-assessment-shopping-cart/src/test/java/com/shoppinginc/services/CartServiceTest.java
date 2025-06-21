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
        assertEquals(8, quantity);

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

    @Test
    public void testRemovePartialItem() {
        Catalog catalog = new Catalog();
        CartService cartService = new CartService(catalog);
        Item bread = catalog.getItemByName("Bread");

        cartService.addItem(bread, 5);
        cartService.removeItem("Bread", 3);

        int remainder = cartService.getCartQuantity("Bread");
        assertEquals(2, remainder);
    }

    @Test
    public void testRemoveMoreThanItemQuantityInCart() {
        Catalog catalog = new Catalog();
        CartService cartService = new CartService(catalog);
        Item coffee = catalog.getItemByName("Coffee");

        cartService.addItem(coffee, 3);
        cartService.removeItem("Coffee", 6);

        int remainder = cartService.getCartQuantity("Coffee");
        assertEquals(0, remainder);
    }
}

