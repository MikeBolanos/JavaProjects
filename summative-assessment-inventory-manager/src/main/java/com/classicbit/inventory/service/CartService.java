package com.classicbit.inventory.service;

import com.classicbit.inventory.model.CartItem;
import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.model.Product;
import com.classicbit.inventory.model.Result;
import com.classicbit.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
    public Result<Void> addToCart(String id, int quantity) {
        // Validate ID and quantity
        if (id == null || id.trim().isEmpty()) {
            return new Result<>(false, "Product ID cannot be null or empty", null);
        }
        if (quantity <= 0) {
            return new Result<>(false, "Quantity must be greater than 0", null);
        }
        // Get InventoryItem by ID
        InventoryItem item = inventoryRepository.getById(id);
        if (item == null) {
            return new Result<>(false, "Product not found with ID: " + id, null);
        }
        // If exists, update cart if quantity is valid
        int currentCartQuantity = cart.containsKey(id) ? cart.get(id).getQuantity() : 0;
        int newTotalQuantity = currentCartQuantity + quantity;
        // if not, return error Result
        if (newTotalQuantity > item.getQuantity()) {
            return new Result<>(false,
                    String.format("Not enough stock. Available: %d, Requested: %d",
                            item.getQuantity(), newTotalQuantity), null);
        }

        if (cart.containsKey(id)) {
            CartItem existingCartItem = cart.get(id);
            existingCartItem.setQuantity(newTotalQuantity);
        } else {
            BigDecimal price = item.getPrice().setScale(2, RoundingMode.HALF_UP);
            BigDecimal extendedPrice = price.multiply((BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP));
            CartItem newCartItem = new CartItem(item.getProduct(), quantity, price, extendedPrice);
            cart.put(id,newCartItem);
        }

        return new Result<>(true, String.format("Added %d of '%s' to cart",
                quantity, item.getProduct().toString()),null);
    }

    public Result<Void> removeFromCart(String id, int quantity) {
        // Validate input
        if (id == null || id.trim().isEmpty()) {
            return new Result<>(false, "Product ID cannot be null or empty", null);
        }
        if (quantity <= 0) {
            return new Result<>(false, "Quantity must be greater than 0", null);
        }
        // If item exists in cart: remove item or update quantity
        if (!cart.containsKey(id)) {
            return new Result<>(false, "Item not in cart", null);
        }

        CartItem cartItem = cart.get(id);
        int currentCartQuantity = cartItem.getQuantity();
        Product product = cartItem.getProduct();

        if (quantity >= currentCartQuantity) {
            cart.remove(id);
            return new Result<>(true, String.format("Removed all os '%s' from cart",
                    product.toString()), null);
        } else {
            cartItem.setQuantity(currentCartQuantity - quantity);
            return new Result<>(true, String.format("Removed %d of '%s' from cart.",
                    quantity, product.toString()), null);
        }
    }

    public Result<BigDecimal> getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        // Loop over cart, calculate total
        for (CartItem item : cart.values()) {
            total = total.add(item.getExtendedPrice());
        }
        return new Result<>(true, "Total calculated", total.setScale(2, RoundingMode.HALF_UP));
    }

    public Result<String> checkout() {
        // If cart is empty, return error
        if (cart.isEmpty()) {
            return new Result<>(false, "Cart is empty", null);
        }
        Result<BigDecimal> totalResult = getTotalPrice();
        if (!totalResult.isSuccess()) {
            return new Result<>(false, totalResult.getMessage(), null);
        }

        BigDecimal total = totalResult.getData();
        // Loop over cart: update inventory quantities
        for (Map.Entry<String, CartItem> entry : cart.entrySet()) {
            String id = entry.getKey();
            CartItem cartItem = entry.getValue();
            InventoryItem item = inventoryRepository.getById(id);

            item.setQuantity(item.getQuantity() - cartItem.getQuantity());
            inventoryRepository.update(item);
        }

        // Clear cart
        cart.clear();

        // Return confirmation with total
        return new Result<>(true,
                String.format("Checkout complete! Total: %s", total),
                String.format("%s", total));
    }

    public List<CartItem> getCartContents() {
        // Return all cart items
        return new ArrayList<>(cart.values());
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }
}
