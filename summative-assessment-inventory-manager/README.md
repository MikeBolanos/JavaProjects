
# 🎮 ClassicBit Inventory Manager

**ClassicBit Inventory Manager** is a Spring Boot console application designed to manage and simulate an inventory of retro video game consoles. It supports two interactive modes:

- 🧑‍💼 **Admin Mode** – for managing inventory: add, update, remove, or view items.
- 🛒 **Kiosk Mode** – for customers to browse consoles, add them to a cart, and checkout.

---

## 📦 Project Structure

```
classicbit.inventory/
├── config/               # Inventory configuration (switch CSV/in-memory)
├── model/                # Product models: Console, RareConsole, etc.
├── repository/           # Repository interfaces and implementations
├── service/              # Business logic for inventory and cart
├── view/                 # AdminInventory, Kiosk, and IO classes
├── command/              # Command pattern implementation
├── InventoryManagerApp.java # Main Spring Boot application class
├── application.properties    # Mode and repo configuration
└── data/inventory.csv        # CSV inventory (optional, auto-created)
```

---

## 🛠 Requirements

- **Java 21**
- **Maven 3.9+**
- Terminal / command line access

---

## 🚀 Running the App

1. **Clone the repo:**

```bash
git clone https://github.com/your-username/classicbit-inventory.git
cd classicbit-inventory
```

2. **Configure the mode and repository:**

Edit `src/main/resources/application.properties`:

```properties
# Choose "admin" or "kiosk"
ui.mode=admin

# Choose "csv" or "memory"
inventory.repository.type=csv

# If using CSV, set the filepath
inventory.csv.filepath=data/inventory.csv
```

> ✅ The app defaults to `kiosk` mode with CSV-based inventory.

3. **Build and run:**

```bash
mvn spring-boot:run
```

---

## 🧑‍💼 Admin Mode

Run with `ui.mode=admin`

### 📋 Features:

- Add or update console inventory
- Remove consoles by ID
- View a specific console
- View full inventory list

### 🧪 Sample Flow:

```
=== ADMIN INVENTORY MANAGEMENT MENU ===
1. Add or Update inventory item
2. Remove inventory item
3. View inventory item by ID
4. View all inventory items
5. Quit

Please select an option (1-5): 1
Enter console ID: NES
Enter name: Nintendo Entertainment System
...
✓ Successfully updated 'NES'
```

---

## 🛒 Kiosk Mode

Run with `ui.mode=kiosk`

### 🛍 Features:

- Add console to shopping cart
- Remove from cart
- View cart
- Checkout and update stock

### 💳 Sample Flow:

```
=== MAIN MENU ===
1. Add console to cart
2. Remove console from cart
3. View cart
4. Checkout
5. Quit

Please select an option (1-5): 1
Enter console ID to add to cart: SNES
Enter quantity: 2
✓ Added 2 of 'Super Nintendo Entertainment System' to cart
```

---

## 🗃 CSV Inventory Format

The file at `data/inventory.csv` stores both regular and rare consoles:

- Regular Console:
  ```
  NES,Nintendo Entertainment System,Nintendo,1985,NTSC-U,5,89.99
  ```

- Rare Console:
  ```
  Rare,RareNES,Nintendo Entertainment System,Nintendo,1985,NTSC-U,Gold Edition,Certificate #NES123,1,899.99
  ```

The system will automatically create or update this file on inventory changes.

---

## 🧪 Testing Options

To simplify testing:

- Set `inventory.repository.type=memory` for sample data (no CSV file required).
- Change `ui.mode` in `application.properties` to switch modes.

---

## 📚 Technologies Used

- Java 21
- Spring Boot 3.4.7
- Maven
- Command-line interface (Scanner-based)
- Command Pattern
- Object-Oriented Design (Inheritance, Polymorphism)

---

## 🕹 Sample Rare Consoles (Memory Mode)

| ID         | Name                                | Rarity            | Certificate              |
|------------|-------------------------------------|-------------------|--------------------------|
| RareNES    | Nintendo Entertainment System       | Gold Edition      | Certificate #NES123      |
| RareSNES   | Super Nintendo Dev Kit              | Developer Unit    | Verified SNES Dev Unit   |
| RareVB     | Virtual Boy JP Model                | Low Production    | Signed by Designer       |
| RareXBOX   | Xbox Halo Edition                   | Limited Edition   | Certificate #117         |

To try these out, use `inventory.repository.type=memory`.

---
