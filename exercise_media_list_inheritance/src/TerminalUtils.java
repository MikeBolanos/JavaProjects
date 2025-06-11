import java.util.Scanner;

public class TerminalUtils {
    private Scanner scanner;

    public TerminalUtils() {
        this.scanner = new Scanner(System.in);
    }

    //Methods

    // getString(String prompt) method
    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
