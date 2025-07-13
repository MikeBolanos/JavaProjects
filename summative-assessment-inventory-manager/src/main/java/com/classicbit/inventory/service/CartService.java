package com.classicbit.inventory.service;

import com.classicbit.inventory.model.CartItem;
import com.classicbit.inventory.model.Result;
import com.classicbit.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    private final InventoryRepository inventoryRepository;
    private final Map<String, CartItem> cart = new HashMap<>();

    // Constructor injection, uses @Autowired to inject InventoryRepository using InventoryConfig setup
    @Autowired
    public CartService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    public Result<Void> addToCart(String productId, int quantity) {
        // Validate ID and quantity
        // Get InventoryItem by ID
        // If exists, update cart if quantity is valid
        // if not, return error Result
    }

    public Result<Void> removeFromCart(String productId, int quantity) {
        // Validate input
        // If item exists in cart:
        // Remove item or update quantity
    }

    public Result<BigDecimal> getTotalPrice() {
        // Loop over cart, calculate total
    }

    public Result<String> checkout() {
        // If cart is empty, return error
        // Loop over cart: update inventory quantities
        // Clear cart
        // Return confirmation with total
    }

    public List<CartItem> getCartContents() {
        // Return all cart items
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }
}
