import java.util.Scanner;

public class Main {

    // define method "selectDrink" to return specific outputs for specific inputs
    private static String selectDrink(String choice) {
        // add print statement to show received input
        System.out.println("Received input: '" + choice + "'");
        choice =(choice.toLowerCase()); // Fixes using uppercase in input

        if (choice.equals("water")) {
            System.out.println("Drink selected: water"); // add print statement to show selected drink before processing
            return "You selected water.";
        } else if (choice.equals("soda")) {
            System.out.println("Drink selected: soda");
            return "You selected soda.";
        } else if (choice.equals("juice")) {
            System.out.println("Drink selected: juice");
            return "You selected juice.";
        } else {
            System.out.println("Invalid selection detected"); // Add print statement to show when invalid choice detected
            return "Invalid selection.";
        }
    }
    // Write method "runTests" to auto verify correct outputs for selectDrink inputs
    private static void runTests() {             // Include WATER, tea, and empty input to test
        String[] inputs = {"water", "soda", "juice", "WATER", "tea", " "};
        String[] outputs = {
                "You selected water.",
                "You selected soda.",
                "You selected juice.",
                "You selected water.", // WATER fails initially, but fixed with .toLowerCase() in selectDrink
                "Invalid selection.",
                "Invalid selection."
        };
        for (int i= 0; i < inputs.length; i++) {
            String input = inputs[i];
            String output = outputs[i];
            System.out.println("\nTesting with " + input + "... ");
            String actual = selectDrink(input);
            if (output.equals(actual)) {
                System.out.println("Passed!");
            } else {
                System.out.println("FAIL: Expected '" + output + "', got '" + actual + "'.");
            }
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String result;

        // Keep asking for input until a valid choice is entered
        do {
            System.out.println("\nSelect a drink (water, soda, or juice): ");
            String userInput = input.nextLine();
            result = selectDrink(userInput);
        } while (result.equals("Invalid selection."));

        // Call runTests in main (uncomment to run)
//        runTests();


    }
}
