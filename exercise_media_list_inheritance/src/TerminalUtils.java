import java.util.Scanner;
import java.util.List;

public class TerminalUtils {
    private final Scanner scanner;

    public TerminalUtils() {
        this.scanner = new Scanner(System.in);
    }

    //Methods

    // displayMenu() - shows the main menu options
    public void displayMenu() {
        System.out.println("\n~*~*~*~Media List Application~*~*~*~");
        System.out.println("1. Add Media");
        System.out.println("2. Remove Media");
        System.out.println("3. Play Media");
        System.out.println("4. List All Media");
        System.out.println("5. Quit");
    }

    // getMenuChoice() - gets and validates menu selection
    public int getMenuChoice() {
        int choice;
        while (true) {
            choice = getInt("\nSelect an option by number: ");
            if (choice >= 1 && choice <= 5) {
                return choice;
            } else {
                System.out.println("Invalid selection. Please choose an option by its number.");
            }
        }

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
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // displayMessage(String message) - displays messages to user
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // displayMediaList(List<Media> mediaList) - formats and displays media list
    public void displayMediaList(List<Media> mediaList) {
        System.out.println("\n~*~*~*~Media List~*~*~*~");
        for (int i = 0; i < mediaList.size(); i++) {
            Media media = mediaList.get(i);
            System.out.printf("%d. %s%n", i + 1, media.getDescription());
        }
    }

}