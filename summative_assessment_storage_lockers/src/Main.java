public class Main {
    public static void main(String[] args) {
        // Variables
        // New LockerService (will create new collection of lockers with chosen amount)
        LockerService lockerService = new LockerService(5);

        // boolean for looping program menu until user quits
        boolean testing = true;

        // Loop:
        // Use while true (boolean) loop for program
        while (testing) {
            // Check if all lockers are rented
            boolean allLockersRented = lockerService.lockersFull();

            // Main menu (testing)
            Utils.print("\n~*~*~*~ Lockdown Lockers Test ~*~*~*~");
            // Check if all lockers are full before displaying Rent option
            if (!allLockersRented) {
                Utils.print("1. Rent a Locker");
            }
            Utils.print("2. Access a Locker");
            Utils.print("3. Release a Locker");
            Utils.print("4. Quit");

            // Prompt for menu choice
            String choice = Utils.prompt("Please choose an option (1, 2, 3, or 4): ");
            MenuOption option = MenuOption.menuChoice(choice);

            //Switch cases for Menu choices
            switch (option) {

                case RENT: // case 1: Rent a locker | Call rentLocker method
                    if (allLockersRented) {
                        Utils.print("All lockers are rented. At least one locker must be released to rent a locker.");
                        break;
                    }
                    Result rent = lockerService.rentLocker();
                    Utils.print(rent.getMessage());
                    break;

                case ACCESS: // case 2: Access a locker | Call accessLocker method
                    String accessPin = Utils.prompt("\nTo access a locker, please enter your PIN: ");
                    Result access = lockerService.accessLocker(accessPin);
                    Utils.print(access.getMessage());
                    break;

                case RELEASE: // case 3: Release a locker |
                    String releasePin = Utils.prompt("\nTo release a locker, please enter your PIN: ");
                    Result release = lockerService.handleLockerRelease(releasePin);
                    Utils.print(release.getMessage());
                    break;

                case QUIT: // case 4: "q" to quit | Call print method
                    Utils.print("\nThanks for using the locker system by Lockdown Inc! Have great day!");
                    testing = false;
                    break;

                default: // Invalid input choice message via print method
                    Utils.print("\nInvalid choice. Please try again.");
            }
        }
    }
}

