# ClassicBit Inventory Manager

The **ClassicBit Inventory Manager** is a Java + Spring Boot application for managing an inventory of retro video game consoles. It supports both an **Admin Mode** (for managing inventory) and a **Kiosk Mode** (for customers to shop and checkout). The application supports both **in-memory** and **CSV-based** inventory repositories.

---

## 🗂 Project Structure

```
com.classicbit.inventory
│
├── config          # Configuration for selecting repository (memory or csv)
├── model           # Data models: Console, RareConsole, InventoryItem, CartItem, etc.
├── repository      # Inventory repository interfaces and implementations
├── service         # Business logic: CartService and InventoryService
├── view            # User Interfaces for Admin (AdminInventory) and Kiosk (Kiosk)
├── command         # Command pattern implementation for handling user actions
└── InventoryManagerApp.java  # Entry point using Spring Boot
```

---

## 💡 How It Works

### Launching the App

The app starts in either Admin or Kiosk mode, depending on this setting in `application.properties`:

```properties
ui.mode=admin       # or kiosk
inventory.repository.type=csv   # or memory
```

Run the app using:

```bash
mvn spring-boot:run
```

### Admin Mode
Use this to manage the inventory (add, update, remove, view consoles).

### Kiosk Mode
Use this for customer-facing interaction (add to cart, remove from cart, checkout).

---

## 📦 Packages Overview

### `config`
- **InventoryConfig** – Configures which repository implementation is used (CSV or in-memory) via `application.properties`.

### `model`
- **Console** – Represents a base console with attributes like name, manufacturer, year, region.
- **RareConsole** – Wraps a Console with extra rarity and certificate information.
- **Product (interface)** – Implemented by Console and RareConsole.
- **InventoryItem** – Associates a Product with quantity and price in the inventory.
- **CartItem** – Represents an item placed in the customer's shopping cart.
- **Result<T>** – Encapsulates the result of service operations (success/failure messages).

### `repository`
- **InventoryRepository (interface)** – Defines CRUD methods for managing inventory.
- **InMemoryInventoryRepository** – In-memory version with sample consoles preloaded.
- **CsvInventoryRepository** – Reads/writes inventory to a CSV file.

### `service`
- **InventoryService** – Provides methods to add, update, remove, and retrieve inventory items.
- **CartService** – Manages the customer’s cart and checkout process.

### `view`
- **AdminInventory** – Admin menu handler, tied to the Command pattern.
- **AdminInventoryIO** – Handles admin input/output and console display formatting.
- **Kiosk** – Customer-facing menu handler.
- **KioskIO** – Handles customer input/output for cart and checkout.

### `command`
- **Command (interface)** – Base interface for all user actions.
- **AddOrUpdateItemCommand, RemoveItemCommand, etc.** – Execute specific actions for admin or kiosk.

---

## 📋 Sample `application.properties`

```properties
# App metadata
spring.application.name=summative-assessment-inventory-manager

# Choose UI mode: admin or kiosk
ui.mode=kiosk

# Choose inventory repository type: memory or csv
inventory.repository.type=csv

# Path to CSV file (used if CSV mode is selected)
inventory.csv.filepath=data/inventory.csv
```

---

## ✅ Features

### Admin Features
- Add or update an inventory item
- Remove an inventory item
- View details of a single item
- View all inventory items

### Kiosk Features
- Add a console to cart
- Remove a console from cart
- View cart contents
- Checkout and update inventory

---

## 📦 Inventory Sample Types

- **Console:** Regular classic systems (NES, SNES, Sega Genesis, etc.)
- **RareConsole:** Limited editions or developer/test variants with rarity and certificate details

---

## 📎 Notes
- CSV files are stored in `data/inventory.csv` (modifiable)
- All inputs are validated for correctness and quantity/stock limits
- Uses Command pattern to handle user actions
