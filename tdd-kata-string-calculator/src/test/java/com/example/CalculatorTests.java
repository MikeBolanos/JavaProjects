package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTests {
    private StringCalculator calc;

     @BeforeEach
    void setUp() {
         calc = new StringCalculator();
     }

     @Test
    @DisplayName("Empty string returns zero")
    void emptyStringReturnsZero() {
         int actual = calc.add("");
         int expected = 0;
         assertEquals(expected, actual);

     }
}
