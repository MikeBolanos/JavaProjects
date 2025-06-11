import java.util.Scanner;

public class TerminalUtils {
    private Scanner scanner;

    public TerminalUtils() {
        this.scanner = new Scanner(System.in);
    }

    //Methods

    // getString(String prompt) method - gets string input with prompt
    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    // getInt(String prompt) method - gets integer input with prompt and validation
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
    // displayMessage(String message) method - displays messages to user
    public String displayMessage(String message) {

    }
}
