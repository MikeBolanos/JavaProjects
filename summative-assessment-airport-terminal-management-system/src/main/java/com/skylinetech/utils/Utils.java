package com.skylinetech.utils;

import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }

    public static int promptInt(String message) {
        System.out.println(message);
        while(!scanner.hasNextInt()) {
            System.out.println("Enter a valid number: ");
            scanner.nextLine();
        }
        return scanner.nextInt();

    }

    public static void print(String message) {
        System.out.println(message);
    }
}