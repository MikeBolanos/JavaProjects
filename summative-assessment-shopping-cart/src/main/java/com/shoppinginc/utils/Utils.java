package com.shoppinginc.utils;

import org.ietf.jgss.GSSName;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    // Print method
    public static void print(String message) {
        System.out.println(message);
    }

    // Prompt for String
    public static String promptString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    // Prompt for int
    public static int promptInt(String prompt) {
        int number = 0;
        boolean valid = false;
        System.out.println(prompt);

        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            valid = true;
        }
    }

}

