package com.classicbit.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestPropertySource(properties = {
		"inventory.csv.filepath=data/test/inventory-test.csv",
		"inventory.csv.seedpath=data/test/inventory-test-seed.csv"
})
@SpringBootTest
class InventoryManagerAppTests {

	@Test
	void contextLoads() {
	}

}
