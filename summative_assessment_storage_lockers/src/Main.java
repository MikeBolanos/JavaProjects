public class Main {
    public static void main(String[] args) {
        // Variables
        // 1) new LockerService (will create new lockers)
        LockerService lockerService = new LockerService(5);

        // 2) boolean for looping program menu until user quits
        boolean testing = true;

        // Loop:
        // Use while true (boolean) loop for program
        while (testing) {
            // Main menu (testing)
            Utils.print("~*~*~*~ Lockdown Lockers Test ~*~*~*~");
            Utils.print("1. Rent a locker");
//            Utils.print("2. Access a Locker");
//            Utils.print("3. Release a locker");
            Utils.print("Q. Quit");

            // Prompt for menu choice
            String choice = Utils.prompt("Please choose an option (1 or Q): ");

            //Switch cases for Menu choices
            switch (choice) {

                case "1": // case 1: Rent a locker | Call rentLocker method
                    Result rent = lockerService.rentLocker();
                    Utils.print(rent.getMessage());
                    break;

//                case "2": // case 2: Access a locker |
//
//                case "3":// case 3: Release a locker |

                case "4": // case 4: "q" to quit | Call print method
                    Utils.print("Thanks for using the locker system by Lockdown Inc! Have great day!");
                    testing = false;
                    break;

                default: // Invalid input choice message via print method
                    Utils.print("Invalid choice. Please try again.");
            }
        }
    }
}

