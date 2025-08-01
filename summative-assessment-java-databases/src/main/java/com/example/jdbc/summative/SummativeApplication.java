package com.example.jdbc.summative;

import com.example.jdbc.summative.controller.MenuController;
import com.example.jdbc.summative.view.IO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SummativeApplication implements CommandLineRunner {
	IO io;
	MenuController menu;
	Environment environment;

	public SummativeApplication(IO io, MenuController menu, Environment environment) {
		this.io = io;
		this.menu = menu;
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(SummativeApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// Prevent from running during unit tests
		for (String env : environment.getActiveProfiles()) {
			if (env.equals("test")) {
				return;
			}
		}

		//Kick off the menu
		io.displayTitle("Bistro Management Application");
		menu.run();
	}
}
