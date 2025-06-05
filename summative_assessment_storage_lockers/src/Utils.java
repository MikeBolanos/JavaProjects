import java.util.Scanner;

public class Utils {

    //Scanner
    private static final Scanner scanner = new Scanner(System.in);

    // Prompt method for Strings
    public static String prompt(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Print method with new line
    public static void print(String message) {
        System.out.println(message);
    }

    // Prompt method for integers with try/catch for valid input
    public static int promptInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                print("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Prompt method for booleans 
    public static boolean promptBoolean(String prompt) {

    }
}


