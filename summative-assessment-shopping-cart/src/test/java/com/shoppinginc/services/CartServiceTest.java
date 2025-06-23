package com.shoppinginc.services;

import com.shoppinginc.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;


import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    private CartService cartService;
    private Catalog catalog;

    @BeforeEach
    void setUp() {
        catalog = new Catalog();
        cartService = new CartService(catalog);
    }

    @Test
    public void testAddSingleItem() {
        // Arrange
        Item apple = catalog.getItemByName("Apple");

        // Act
        cartService.addItem(apple, 1);

        // Assert
        int actual = 0;
        for (Item item : cartService.getCartItems()) {
            if (item.getName().equals("Apple")) {
                actual++;
            }
        }

        int expected = 1;
        assertEquals(expected, actual);

    }


    @Test
    public void testAddMultipleItems() {

        Item milk = catalog.getItemByName("Milk");

        cartService.addItem(milk, 4);

        int count = 0;

        for (Item item : cartService.getCartItems()) {
            if (item.getName().equals("Milk")) {
                count++;
            }
        }

        int expected = 4;
        int actual = count;
        assertEquals(expected, actual);
    }

    @Test
    public void testAddMultipleItemTypes() {
        Item banana = catalog.getItemByName("Banana");
        Item coffee = catalog.getItemByName("Coffee");

        cartService.addItem(banana, 2);
        cartService.addItem(coffee, 3);

        int bananaCount = 0;
        int coffeeCount = 0;

        for (Item item : cartService.getCartItems()) {
            if (item.getName().equals("Banana")) {
                bananaCount++;
            }
            if (item.getName().equals("Coffee")) {
                coffeeCount++;

            }
        }
        int expectedBananaCount = 2;
        int expectedCoffeeCount = 3;

        assertEquals(expectedBananaCount, bananaCount);
        assertEquals(expectedCoffeeCount, coffeeCount);
    }

    @Test
    public void testAddingNegativeQuantity(){
        Item pb = catalog.getItemByName("Peanut Butter");

        cartService.addItem(pb, -1);

        int count = 0;
        for (Item item : cartService.getCartItems()) {
            if (item.getName().equals("Peanut Butter")) {
                count++;
            }
        }
        int expectedPbCount = 0;

        assertEquals(expectedPbCount, count);
    }



    @Test
    public void testRemoveFullItem() {

        Item apple = catalog.getItemByName("Apple");

        cartService.addItem(apple, 1);
        cartService.removeItem("Apple", 1);

        int count = 0;
        for (Item item : cartService.getCartItems()) {
            if (item.getName().equals("Apple")) {
                count++;
            }
        }

        int expected = 0;

        assertEquals(expected, count);
    }
}
//
//    @Test
//    public void testRemovePartialItem() {
//        Catalog catalog = new Catalog();
//        CartService cartService = new CartService(catalog);
//        Item bread = catalog.getItemByName("Bread");
//
//        cartService.addItem(bread, 5);
//        cartService.removeItem("Bread", 3);
//
//        int remainder = cartService.getCartQuantity("Bread");
//        assertEquals(2, remainder);
//    }
//
//    @Test
//    public void testRemoveMoreThanItemQuantityInCart() {
//        Catalog catalog = new Catalog();
//        CartService cartService = new CartService(catalog);
//        Item coffee = catalog.getItemByName("Coffee");
//
//        cartService.addItem(coffee, 3);
//        cartService.removeItem("Coffee", 6);
//
//        int remainder = cartService.getCartQuantity("Coffee");
//        assertEquals(0, remainder);
//    }
//
//    @Test
//    public void testDisplayCartOneItem() {
//        Catalog catalog = new Catalog();
//        CartService cartService = new CartService(catalog);
//        Item yogurt = catalog.getItemByName("Yogurt");
//
//        cartService.addItem(yogurt, 4);
//
//        // Need to capture output using ByteArrayOutputStream and System.out
//        // BAOS acts as a text bucket, catching whatever is printed
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        PrintStream originalOutput = System.out; // Storing the original output print stream
//        // Print output here instead of in console
//        System.setOut(new PrintStream(outputStream));
//
//        cartService.displayCart();
//
//        // Restore System.out so future tests can print to the console again
//        System.setOut(originalOutput);
//
//        String output = outputStream.toString(); // turns the captured text into a String
//        assertTrue(output.contains("Yogurt"));
//        assertTrue(output.contains("x4"));
//        assertTrue(output.contains("2.39"));
//    }
//
//    @Test
//    public void testIsDisplayCartEmpty() {
//        Catalog catalog = new Catalog();
//        CartService cartService = new CartService(catalog);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        PrintStream originalOutput = System.out;
//        System.setOut(new PrintStream(outputStream));
//
//        cartService.displayCart();
//
//        System.setOut(originalOutput);
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("The cart is empty"));
//    }
//
//    @Test
//    public void testIsDisplayCartMultipleItems() {
//        Catalog catalog = new Catalog();
//        CartService cartService = new CartService(catalog);
//        Item rice = catalog.getItemByName("Rice");
//        Item cheese = catalog.getItemByName("Cheese");
//
//        cartService.addItem(rice, 3);
//        cartService.addItem(cheese, 2);
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        PrintStream originalOutput = System.out;
//        System.setOut(new PrintStream(outputStream));
//
//        cartService.displayCart();
//
//        System.setOut(originalOutput);
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("Rice") && output.contains("$ 2.99") && output.contains("x3"));
//        assertTrue(output.contains("Cheese") && output.contains("$ 4.49") && output.contains("x2"));
//        assertTrue(output.contains("Subtotal"));
//    }
//
//    @Test
//    public void testCheckoutCalculation() {
//        Catalog catalog = new Catalog();
//        CartService cartService = new CartService(catalog);
//
//        Item peanutButter = catalog.getItemByName("Peanut Butter");
//        Item jelly = catalog.getItemByName("Jelly");
//
//        cartService.addItem(peanutButter, 2);
//        cartService.addItem(jelly, 2);
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        PrintStream originalOutput = System.out;
//        System.setOut(new PrintStream(outputStream));
//
//        cartService.checkout();
//
//        System.setOut(originalOutput);
//
//        String output = outputStream.toString();
//
//        assertTrue(output.contains("Subtotal:"));
//        assertTrue(output.contains("Sales Tax:"));
//        assertTrue(output.contains("Total:"));
//        assertTrue(output.contains("$ 14.76"));
//        assertTrue(output.contains("$  1.21"));
//        assertTrue(output.contains("$ 15.97"));
//    }
//    @Test
//    public void testCheckoutIfCartIsEmpty() {
//        Catalog catalog = new Catalog();
//        CartService cartService = new CartService(catalog);
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        PrintStream originalOutput = System.out;
//        System.setOut(new PrintStream(outputStream));
//
//        cartService.checkout();
//
//        System.setOut(originalOutput);
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("The cart is empty"));
//        assertFalse(output.contains("Subtotal"));
//        assertFalse(output.contains("Total"));
//    }
//}

