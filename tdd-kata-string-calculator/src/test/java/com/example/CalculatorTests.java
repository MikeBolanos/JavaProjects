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

     @Test
     @DisplayName("Single number returns number")
    void oneNumberReturnsNumber() {
         int actual = calc.add("5");
         int expected = 5;
         assertEquals(expected, actual);
     }


     @Test
    @DisplayName("Two numbers returns sum")
         void twoNumbersReturnsSum() {
         int actual = calc.add("5,3");
         int expected = 8;

         assertEquals(expected, actual);
     }

     @Test
    @DisplayName ("Multiple numbers return sum")
        void multipleNumbersReturnsSum() {
         int actual = calc.add ("1,2,3,4");
         int expected = 10;
         assertEquals(expected, actual);

     }

     @Test
    @DisplayName("Allow new line between numbers")
        void allowNewLineBetweenNumbers() {
         int actual = calc.add("1\n2,3");
         int expected = 6;
         assertEquals(expected, actual);
     }

     @Test
    @DislayName("Support different delimiters")
        void supportDifferentDelimiters() {
         int actual = calc.add("//;\n1;2;3");
         int expected = 6;
         assertEquals(expected, actual);
     }

}
