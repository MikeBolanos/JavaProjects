package com.classicbit.inventory.view;

import com.classicbit.inventory.model.InventoryItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class AdminInventoryIO {
    // Scanner for user input

    public void displayWelcome() {
        // print welcome header
    }

    public void displayGoodbye() {
        // print goodbye message
    }

    public int displayMenuAndGetChoice() {
        // print numbered menu
        // return get user input as int
    }

    public String getStringInput(String prompt) {
        // print prompt
        // read input, validate it's not empty
        // return value
    }

    public Integer getIntegerInput(String prompt) {
        // print prompt
        // read input, validate it's a positive int
        // return value
    }

    public BigDecimal getBigDecimalInput(String prompt) {
        // print prompt
        // read input, validate it’s a valid decimal
        // return value
    }

    public boolean getConfirmation(String prompt) {
        // prompt user with (y/n)
        // return true if user enters yes
    }

    public void displayInventoryItems(List<InventoryItem>) {
        // print table headers
        // print each item: ID, name, type, quantity, price
    }

    public void displaySingleItem(InventoryItem) {
        // print detailed view of one item
    }

    public void displaySuccess(String msg), displayError(String msg), displayInfo(String msg) {
        // print nicely formatted messages
    }

    public void displaySectionHeader(String title) {
        // visually separate sections (like "=== ADD ITEM ===")
    }
}