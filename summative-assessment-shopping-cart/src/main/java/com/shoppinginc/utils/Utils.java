package com.shoppinginc.utils;

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

    

}

