import java.util.Scanner;

public class Utils {

    //Scanner
    private static final Scanner scanner = new Scanner(System.in);

    // Prompt method for Strings
    public static String prompt(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Print method
    public static void print(String message) {
        System.out.println(message);
    }
}


