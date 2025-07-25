package com.example.jdbc.summative;

import com.example.jdbc.summative.data.exceptions.RecordNotFoundException;
import com.example.jdbc.summative.data.impl.MySQLTaxRepo;
import com.example.jdbc.summative.model.Tax;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Sql("/sql/reset_db.sql")
public class MySQLTaxRepoTest {
    @Autowired
    private MySQLTaxRepo taxRepo;

    @Test
    void testGetCurrentTaxWithValidDateReturnsCorrectTax() throws Exception {
        // Arrange: use a date that falls within a known tax range
        LocalDate date = LocalDate.of(2023, 10, 15);

        // Act
        Tax tax = taxRepo.getCurrentTax(date);

        // Assert
        assertNotNull(tax);
        assertEquals(new BigDecimal("6.25"), tax.getTaxPercentage());
        assertEquals(LocalDate.of(2022, 1, 1), tax.getStartDate());
        assertNull(tax.getEndDate()); // assuming NULL means ongoing
    }

    @Test
    void testGetCurrentTaxWithNoTaxForDate() {
        // Date where no tax should exist
        LocalDate date = LocalDate.of(1990, 1, 1);

        assertThrows(RecordNotFoundException.class, () -> {
            taxRepo.getCurrentTax(date);
        });
    }
}

