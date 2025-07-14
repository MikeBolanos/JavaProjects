package com.classicbit.inventory;

import com.classicbit.inventory.ui.AdminInventory;
import com.classicbit.inventory.ui.Kiosk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Enables component scanning and auto-configuration
public class InventoryManagerApp implements CommandLineRunner {

	// Inject Admin interface to manage inventory
	@Autowired
	private AdminInventory adminInventory;

	// Inject the Kiosk interface for customers to shop
	@Autowired
	private Kiosk kiosk;

	/**
	 * Read the startup mode from application.properties:
	 * If not specified, default to "kiosk"
	 * Example line in properties: classicbit.mode=admin
	 */

	@Value("${ui.mode:kiosk}")
	private String mode;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApp.class, args);
	}

	@Override
	public void run(String... args) {

		if (mode.equalsIgnoreCase("admin")) {
			adminInventory.run();
		} else {
			kiosk.run();
		}
	}
}
