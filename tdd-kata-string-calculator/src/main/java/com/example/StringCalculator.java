package com.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            String [] nums = numbers.split(",");
            return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
        }
    }
}
