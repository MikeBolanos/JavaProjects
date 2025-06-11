import java.io.PrintStream;
import java.util.Scanner;

public class TerminalUtils {
    private final Scanner scanner;

    public TerminalUtils() {
        this.scanner = new Scanner(System.in);
    }

    //Methods

    // displayMenu() - shows the main menu options
    public void displayMenu() {
        System.out.println("\n~*~*~*~Media Library~*~*~*~");
        System.out.println("1. Add Media");
        System.out.println("2. Remove Media");
        System.out.println("3. Play Media");
        System.out.println("4. List All Media");
        System.out.print("5. Quit");
    }
    // getString(String prompt) method - gets string input with prompt
    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    // getInt(String prompt) - gets integer input with prompt and validation
    public int getInt(String prompt) {
        // Add validation for input to ensure int
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        }
    }

    // displayMessage(String message) - displays messages to user
    public void displayMessage(String message) {
        System.out.println(message);
    }

}