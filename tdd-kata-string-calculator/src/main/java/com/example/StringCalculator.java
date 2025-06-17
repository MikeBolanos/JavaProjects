package com.example;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] nums;


//         else if (!numbers.contains(",")) {
//            return Integer.parseInt(numbers);


        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiter = parts[0].substring(2);
            nums = parts[1].split(Pattern.quote(delimiter));

        } else {
           nums = numbers.split("[,\n]"); // [,\n] => combination of both symbols
//            return getSum(nums);
        }


//    private int getSum(String[] nums) {
        int sum = 0;

        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
    //[delimiter]\n[numbers...]

    // 1) Detect if string starts with "//"
    // 2) Strip delimiter: ";" , "-" , "."
    // 3) Use the delimiter instead of commas or "\n" to split numbers
    // 4) Keep existing scenarios supported


    // full string
    // Split the string into two parts:
    // String[] parts = numbers.split("\n", 2) => // splits the newline character and "2" means "at most, two parts"
    // "/n" is the delimiter line (//; or //. or //-)
    // so parts [0] is "/n"
    // and parts [1] is "1;2;3;etc..." (actual numbers)

    // Need to take out delimiter first, then split numbers using delimiter(?)
    // Need to use .substring to get delimiter "//;"
    // need to use Pattern.quote to split numbers using the delimiter
    //so for "//;\n1;2;3"
//    String[] parts = numbers.split("\n", 2);
//    String delimiter = parts [0].substring(2); // This gets the delimiter ";"
//    String[] nums = parts[1].split(Pattern.quote(delimiter)); // Should split 1;2;3



    // Throw an exception if negative numbers present
    // Include all negative numbers in the exception message
    //




