package com.shoppinginc.utils;

import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    // Print method
    public static void print(String message) {
        System.out.println(message);
    }

    // Prompt for String
    public static void promptString(String prompt) {
        System.out.println(prompt);
        scanner.nextLine();
    }


    // Prompt for int
    public static int promptInt(String prompt) {
        int number = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println(prompt);

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                valid = true;
            } else {
                System.out.println("That is not a valid number. Please try again.");
            }

        }
        return number;
    }

}

