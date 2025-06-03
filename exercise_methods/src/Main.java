import java.io.InvalidClassException;

public class Main {

    // 1. Define a method called printWelcomeMessage (does not return anything)
    public static void printWelcomeMessage(String message) {
        System.out.println(message);
    }

    // 2. Define a method "sum" that returns the sum of two integers
    public static int sum(int a, int b) {
        return a + b;
    }

    // 3. Define a method "convertToFahrenheit" that converts a Celsius value into an equivalent Fahrenheit value
     public static double convertToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;

    }

    // 4. Define a method "isEven" that returns true if a number is even and false if odd
    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true; // returns true if the number is divisible by 2 without remainders
        } else {
            return false; // returns false if not
        }
    }

    // 5. Define a method "printMultipleTimes" that prints a string n times
    public static void printMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    // 6. Define a method "findMax" that returns the largest of three integers
    public static int findMax(int a, int b, int c) {
        int max = Math.max(a,b); // Can only fit two arguments
        return Math.max(c,max); // So use max of previous two arguments to compare to last integer to get max of all three
    }

    // 7. Define a method "factorial" that calculates the factorial of a number using recursion
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    // 8. Define two methods both named "greet"
        // Method 1
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
        // Method 2
    public static void greet(String name, int age) {
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }
    public static void main(String[] args) {

        // Call printWelcomeMessage method inside main
        printWelcomeMessage("\nWelcome to the Java Methods exercise!");

        // Call sum method with different results and print them.
        int sum1 = sum(10, 15);
        int sum2 = sum(2,40);
        int sum3 = sum(13,5);

        System.out.println("\nThe sum of 10 and 15 is: " + sum1);
        System.out.println("The sum of 2 and 40 is: "  + sum2);
        System.out.println("The sum of 13 and 5 is: " + sum3);

        // Call convertToFahrenheit in main with different values and print results
        double f1 = convertToFahrenheit(5);
        double f2 = convertToFahrenheit(25);
        double f3 = convertToFahrenheit(13);

        System.out.println("\n5°C = " + f1 + "°F");
        System.out.println("25°C = " + f2 + "°F");
        System.out.println("13°C = " + f3 + "°F");

        // Call isEven within main
        System.out.println("\nThe number 7 is even: " + isEven(7));
        System.out.println("The number 8 is even: " + isEven(8));
        System.out.println("The number 22 is even: " + isEven(22));
        System.out.println("The number 43 is even: " + isEven(43));


        // Call printMultipleTimes in main with different values
        System.out.println("\nPrinting words a defined amount of times:");
        printMultipleTimes("blah", 3);
        printMultipleTimes("echo!", 2);
        printMultipleTimes("Well...", 5);

        // Call findMax and print results of different values
        System.out.println("\nMaximums:");
        int result = findMax(4,2,9);
        System.out.println(result);
        System.out.println(findMax(5, 33, 21));
        System.out.println(findMax(103, 75, 234));

        // Call factorial and print results for 5, 7, and 10
        System.out.println("\nThe factorials of 5, 7 and 10 are: ");
        System.out.println("5! = " + factorial(5));
        System.out.println("7! = " + factorial(7));
        System.out.println("10! = " + factorial(10));

        // Call both methods with different arguments
        System.out.println("\nOverloaded methods output:");
        greet("Xander");
        greet("Mike", 35);

    }
}


