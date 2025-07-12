package com.classicbit.inventory.repository;

import com.classicbit.inventory.model.Console;
import com.classicbit.inventory.model.InventoryItem;

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
        addSampleConsole("ATARI-2600-001", "Atari 2600", "Atari", "1977", "NTSC-U", 3, "59.99");
        addSampleConsole("ATARI-7800-002", "Atari 7800", "Atari", "1986", "NTSC-U", 2, "69.99");
        addSampleConsole("ATARI-JAG-003", "Atari Jaguar", "Atari", "1993", "NTSC-U", 1, "99.99");
        addSampleConsole("ATARI-LYNX-004", "Atari Lynx", "Atari", "1989", "Region-Free", 1, "89.99");

        // NEC and Hudson Soft Consoles
        addSampleConsole("NEC-PCEGT-001", "TurboExpress (PC Engine GT)", "NEC", "1990", "NTSC-J", 1, "199.99");
        addSampleConsole("NEC-TG16-002", "TurboGrafx-16", "NEC", "1989", "NTSC-U", 4, "129.99");
        addSampleConsole("NEC-TGCD-003", "TurboGrafx-CD", "NEC", "1990", "NTSC-U", 1, "149.99");

        // Nintendo Consoles
        addSampleConsole("NINTENDO-NES-001", "Nintendo Entertainment System", "Nintendo", "1985", "NTSC-U", 5, "89.99");
        addSampleConsole("NINTENDO-SNES-002", "Super Nintendo Entertainment System", "Nintendo", "1991", "NTSC-U", 4, "109.99");
        addSampleConsole("NINTENDO-N64-003", "Nintendo 64", "Nintendo", "1996", "NTSC-U", 6, "99.99");
        addSampleConsole("NINTENDO-GB-004", "Game Boy", "Nintendo", "1989", "Region-Free", 3, "49.99");
        addSampleConsole("NINTENDO-GBC-005", "Game Boy Color", "Nintendo", "1998", "Region-Free", 2, "69.99");
        addSampleConsole("NINTENDO-GBA-006", "Game Boy Advance", "Nintendo", "2001", "Region-Free", 7, "89.99");
        addSampleConsole("NINTENDO-GCN-007", "GameCube", "Nintendo", "2001", "NTSC-U", 5, "119.99");
        addSampleConsole("NINTENDO-VB-008", "Virtual Boy", "Nintendo", "1995", "NTSC-U", 1, "149.99");
        addSampleConsole("NINTENDO-WII-009", "Nintendo Wii", "Nintendo", "2006", "NTSC-U", 8, "79.99");

        // Sega Consoles
        addSampleConsole("SEGA-GG-001", "Game Gear", "Sega", "1990", "Region-Free", 2, "59.99");
        addSampleConsole("SEGA-MD-002", "Sega Genesis (Mega Drive)", "Sega", "1988", "NTSC-U", 6, "79.99");
        addSampleConsole("SEGA-CD-003", "Sega CD", "Sega", "1991", "NTSC-U", 2, "129.99");
        addSampleConsole("SEGA-SAT-004", "Sega Saturn", "Sega", "1994", "NTSC-U", 3, "139.99");
        addSampleConsole("SEGA-DC-005", "Sega Dreamcast", "Sega", "1999", "NTSC-U", 4, "109.99");

        // SNK Consoles
        addSampleConsole("SNK-NG-001", "Neo Geo AES", "SNK", "1990", "NTSC-U", 1, "299.99");
        addSampleConsole("SNK-NGP-002", "Neo Geo Pocket", "SNK", "1998", "NTSC-J", 2, "79.99");

        // Sony Consoles
        addSampleConsole("SONY-PS1-001", "PlayStation", "Sony", "1995", "NTSC-U", 5, "79.99");
        addSampleConsole("SONY-PS2-002", "PlayStation 2", "Sony", "2000", "NTSC-U", 6, "99.99");

        // Microsoft Consoles
        addSampleConsole("MICROSOFT-XBOX-001", "Xbox", "Microsoft", "2001", "NTSC-U", 5, "89.99");

    }
    private void addSampleConsole(String id,
                                  String name,
                                  String manufacturer,
                                  String releaseYear,
                                  String regionLock,
                                  int quantity,
                                  String price) {

        Console console = new Console(id,name,manufacturer,releaseYear, regionLock);

        InventoryItem item = new InventoryItem(console, quantity, new BigDecimal(price));
        inventory.put(id,item);
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
        inventory.put(item.getConsole().id(), item);
    }

    @Override
    public void update(InventoryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        String id = item.getConsole().id();
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