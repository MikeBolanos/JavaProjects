package com.classicbit.inventory;

import com.classicbit.inventory.model.CartItem;
import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.model.Result;
import com.classicbit.inventory.repository.InMemoryInventoryRepository;
import com.classicbit.inventory.repository.InventoryRepository;
import com.classicbit.inventory.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import java.util.List;

public class CartServiceTests {
    private CartService cartService;
    private InventoryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryInventoryRepository();
        cartService = new CartService(repository);
    }

    @Test
    void testAddToCart_Valid() {
        Result<Void> result = cartService.addToCart("NES", 2);
        assertTrue(result.isSuccess());
        assertEquals(1, cartService.getCartContents().size());
    }

    @Test
    void testAddToCart_TooMuchQuantity() {
        InventoryItem item = repository.getById("N64");
        int stock = item.getQuantity();

        Result<Void> result = cartService.addToCart("N64", stock + 1);
        assertFalse(result.isSuccess());
        assertTrue(result.getMessage().contains("Not enough stock"));
    }

    @Test
    void testRemoveFromCart_AllQuantity() {
        cartService.addToCart("NES", 2);
        Result<Void> result = cartService.removeFromCart("NES", 2);
        assertTrue(result.isSuccess());
        assertTrue(cartService.isEmpty());
    }

    @Test
    void testRemoveFromCart_PartialQuantity() {
        cartService.addToCart("NES", 3);
        Result<Void> result = cartService.removeFromCart("NES", 1);
        assertTrue(result.isSuccess());

        CartItem remaining = cartService.getCartContents().get(0);
        assertEquals(2, remaining.getQuantity());
    }

    @Test
    void testCheckout_Success() {
        cartService.addToCart("NES", 1);
        Result<String> result = cartService.checkout();
        assertTrue(result.isSuccess());
        assertTrue(result.getMessage().contains("Checkout complete"));
        assertTrue(cartService.isEmpty());
    }

    @Test
    void testCheckout_EmptyCart() {
        Result<String> result = cartService.checkout();
        assertFalse(result.isSuccess());
        assertEquals("Cart is empty", result.getMessage());
    }

    @Test
    void testGetTotalPrice() {
        cartService.addToCart("NES", 1);
        cartService.addToCart("SNES", 2);

        Result<BigDecimal> result = cartService.getTotalPrice();
        assertTrue(result.isSuccess());
        assertNotNull(result.getData());
        assertTrue(result.getData().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testIsEmptyAndGetCartContents() {
        assertTrue(cartService.isEmpty());
        cartService.addToCart("NES", 1);
        assertFalse(cartService.isEmpty());

        List<CartItem> cart = cartService.getCartContents();
        assertEquals(1, cart.size());
    }
}
