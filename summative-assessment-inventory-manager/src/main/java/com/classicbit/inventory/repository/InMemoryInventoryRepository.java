package com.classicbit.inventory.repository;

import com.classicbit.inventory.model.Console;
import com.classicbit.inventory.model.InventoryItem;
import com.classicbit.inventory.model.RareConsole;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryInventoryRepository implements InventoryRepository {

    private final Map<String, InventoryItem> inventory = new HashMap<>();

    public InMemoryInventoryRepository() {
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Atari Consoles
        addSampleConsole("2600", "Atari 2600", "Atari", "1977", "NTSC-U", 3, "59.99");
        addSampleConsole("7800", "Atari 7800", "Atari", "1986", "NTSC-U", 2, "69.99");
        addSampleConsole("JAG", "Atari Jaguar", "Atari", "1993", "NTSC-U", 1, "99.99");
        addSampleConsole("LYNX", "Atari Lynx", "Atari", "1989", "Region-Free", 1, "89.99");

        // NEC and Hudson Soft Consoles
        addSampleConsole("PCEGT", "TurboExpress (PC Engine GT)", "NEC", "1990", "NTSC-J", 1, "199.99");
        addSampleConsole("TG16", "TurboGrafx-16", "NEC", "1989", "NTSC-U", 4, "129.99");
        addSampleConsole("TGCD", "TurboGrafx-CD", "NEC", "1990", "NTSC-U", 1, "149.99");

        // Nintendo Consoles
        addSampleConsole("NES", "Nintendo Entertainment System", "Nintendo", "1985", "NTSC-U", 5, "89.99");
        addSampleConsole("SNES", "Super Nintendo Entertainment System", "Nintendo", "1991", "NTSC-U", 4, "109.99");
        addSampleConsole("N64", "Nintendo 64", "Nintendo", "1996", "NTSC-U", 6, "99.99");
        addSampleConsole("GB", "Game Boy", "Nintendo", "1989", "Region-Free", 3, "49.99");
        addSampleConsole("GBC", "Game Boy Color", "Nintendo", "1998", "Region-Free", 2, "69.99");
        addSampleConsole("GBA", "Game Boy Advance", "Nintendo", "2001", "Region-Free", 7, "89.99");
        addSampleConsole("GCN", "GameCube", "Nintendo", "2001", "NTSC-U", 5, "119.99");
        addSampleConsole("VB", "Virtual Boy", "Nintendo", "1995", "NTSC-U", 1, "149.99");
        addSampleConsole("WII", "Nintendo Wii", "Nintendo", "2006", "NTSC-U", 8, "79.99");

        // Sega Consoles
        addSampleConsole("GG", "Game Gear", "Sega", "1990", "Region-Free", 2, "59.99");
        addSampleConsole("MD", "Sega Genesis (Mega Drive)", "Sega", "1988", "NTSC-U", 6, "79.99");
        addSampleConsole("CD", "Sega CD", "Sega", "1991", "NTSC-U", 2, "129.99");
        addSampleConsole("SATURN", "Sega Saturn", "Sega", "1994", "NTSC-U", 3, "139.99");
        addSampleConsole("DC", "Sega Dreamcast", "Sega", "1999", "NTSC-U", 4, "109.99");

        // SNK Consoles
        addSampleConsole("NG", "Neo Geo AES", "SNK", "1990", "NTSC-U", 1, "299.99");
        addSampleConsole("NGP", "Neo Geo Pocket", "SNK", "1998", "NTSC-J", 2, "79.99");

        // Sony Consoles
        addSampleConsole("PS1", "PlayStation", "Sony", "1995", "NTSC-U", 5, "79.99");
        addSampleConsole("PS2", "PlayStation 2", "Sony", "2000", "NTSC-U", 6, "99.99");

        // Microsoft Consoles
        addSampleConsole("XBOX", "Xbox", "Microsoft", "2001", "NTSC-U", 5, "89.99");


        // Rare Consoles
        addSampleRareConsole("RareNES", "Nintendo Entertainment System", "Nintendo", "1985", "NTSC-U", "Gold Edition", "Certificate #NES123", 1, "899.99");
        addSampleRareConsole("RareSNES", "Super Nintendo Dev Kit", "Nintendo", "1991", "NTSC-U", "Developer Unit", "Verified SNES Dev Unit", 1, "1499.99");
        addSampleRareConsole("RareTG16", "TurboGrafx-16 White", "NEC", "1990", "NTSC-J", "White Variant", "Promo Unit #21", 1, "799.99");
        addSampleRareConsole("RareVB", "Virtual Boy JP Model", "Nintendo", "1995", "NTSC-J", "Low Production", "Signed by Designer", 1, "1399.99");
        addSampleRareConsole("RareNG", "Neo Geo AES Gold", "SNK", "1990", "NTSC-U", "Gold Trim", "COA #NG1990", 1, "1899.99");
        addSampleRareConsole("RareGBC", "Game Boy Color - Clear Shell", "Nintendo", "1998", "Region-Free", "Special Color Variant", "Retail Limited", 2, "199.99");
        addSampleRareConsole("RareSATURN", "Sega Saturn V-Saturn", "Sega", "1994", "NTSC-J", "Victor V-Saturn", "Original JP Release", 1, "999.99");
        addSampleRareConsole("RareDC", "Dreamcast HK Edition", "Sega", "1999", "NTSC-HK", "HK Variant", "HK Retail Seal", 1, "1099.99");
        addSampleRareConsole("RareGCN", "Resident Evil Biohazard GCN", "Nintendo", "2001", "NTSC-J", "Capcom Edition", "Capcom Promo", 1, "1299.99");
        addSampleRareConsole("RareXBOX", "Xbox Halo Edition", "Microsoft", "2001", "NTSC-U", "Limited Edition", "Certificate #117", 1, "699.99");


    }
    private void addSampleConsole(String id,
                                  String name,
                                  String manufacturer,
                                  String releaseYear,
                                  String regionLock,
                                  int quantity,
                                  String price) {

        Console console = new Console(id, name, manufacturer, releaseYear, regionLock);

        InventoryItem item = new InventoryItem(console, quantity, new BigDecimal(price));
        inventory.put(id, item);
    }

private void addSampleRareConsole(String id,
                                  String name,
                                  String manufacturer,
                                  String releaseYear,
                                  String regionLock,
                                  String rarity,
                                  String certificate, int quantity, String price) {

    Console base = new Console(id, name, manufacturer, releaseYear, regionLock);

    RareConsole rare = new RareConsole(base, rarity, certificate);

    InventoryItem item = new InventoryItem(rare, quantity, new BigDecimal(price));
    inventory.put(id, item);
}

    @Override
    public List<InventoryItem> getAll() {return new ArrayList<>(inventory.values());
    }

    @Override
    public List<InventoryItem> getInStock() {
        return inventory.values().stream()
                .filter(item -> item.getQuantity() > 0)
                .collect(Collectors.toList());
        }

    @Override
    public void add(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        inventory.put(item.getProduct().getId(), item);
    }

    @Override
    public void update(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        String id = item.getProduct().getId();
        if (!inventory.containsKey(id)) {
            throw new IllegalArgumentException("Item with id " + id + " not found");
        }
        inventory.put(id, item);
    }

    @Override
    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        inventory.remove(id);
    }

    public InventoryItem getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return inventory.get(id);
    }
}