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
    @DisplayName("Support different delimiters")
        void supportDifferentDelimiters() {

         int actual = calc.add("//.\n1.2.3");

         int expected = 6;

         assertEquals(expected, actual);

     }

     @Test
    @DisplayName("negativeNumbersThrowsException")
        void negativeNumbersThrowsException() {                     // class refers to the type IAE, not a new instance
                                                                    // -> is a lambda expression that allows a way to pass code as an argument
         Exception exception = assertThrows(IllegalArgumentException.class, () -> {
             calc.add("-1,2,3,4"); // calling add method with one negative number "-1"
         });

        // Expected result with single negative number, actual result
         assertEquals("Negatives not allowed: -1", exception.getMessage());


         exception = assertThrows(IllegalArgumentException.class, () -> {
             calc.add("1,-2,3,-4");
         });


         // Expected result with multiple negative numbers, actual result
         assertEquals("Negatives not allowed: -2, -4", exception.getMessage());

     }

     @Test
    @DisplayName("Numbers Greater Than 1000 are Ignorged")
    void numberGreaterThan1000Ignored() {
         int actual = calc.add("5,1010");
         int expected = 5;
         assertEquals(expected, actual);
     }


}
