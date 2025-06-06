import jdk.jshell.execution.Util;

public class Main {
    public static void main(String[] args) {
        // Variables
        // 1) # of lockers(?)
        // 2) new LockerService

        // 3) boolean for looping program menu until user quits
        boolean testing = true;

        // Loop:
        // Use while true (boolean) loop for program
        while (testing) {
            // Main menu (testing)
            Utils.print("\n~*~*~*~ Locker Test ~*~*~*~");
            Utils.print("1. Rent a locker");
            Utils.print("2. Access a Locker");
            Utils.print("3. Release a locker");
            Utils.print("Q. Quit");

            // Prompt for menu choice
            String choice = Utils.prompt("Please choose an option (1, 2, 3, or Q");

            //Switch cases for Menu choices
            switch (choice) {
                // case 1: Rent a locker
                case "1":

                    // case 2: Access a locker
                case "2":
                    // case 3: Release a locker
                case "3":
                    // case 4: "q" to quit
                case "4":
            }
        } // Exit/ Thank you message
    }
}

