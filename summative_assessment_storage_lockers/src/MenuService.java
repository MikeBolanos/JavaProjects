public class MenuService {
    // Locker Service
    private final LockerService lockerService;
    // boolean for loop
    private boolean looping;

    // Constructor for LockerService
    public MenuService(LockerService lockerService) {
        this.lockerService = lockerService;
        this.looping = true;
    }

    public enum MenuOption {
        RENT("1"),
        ACCESS("2"),
        RELEASE("3"),
        QUIT("4"),
        INVALID("");


        // Variable to store user input for option
        private final String number;

        // Constructor
        MenuOption(String number) {
            this.number = number;
        }

        // Method for menu options
        public static MenuOption menuChoice(String input) {
            input = input.trim();
            for (MenuOption option : values()) {
                if (option.number.equals(input)) {
                    return option;
                }
            }
            return INVALID;
        }
    }

    public void menuLoop() {
        // Loop:
        // Use while true (boolean) loop for Menu
        while (looping) {
            // Check if all lockers are rented
            boolean allLockersRented = lockerService.lockersFull();
            // Check is any locker is rented
            boolean anyLockersRented = lockerService.anyLockerRented();

            // Main menu
            Utils.print("\n~*~*~*~ Lockdown Lockers Test ~*~*~*~");
            // Check if all lockers are full before displaying Rent option
            if (!allLockersRented) {
                Utils.print("1. Rent a Locker");
            }
            if (anyLockersRented) {
                Utils.print("2. Access a Locker");
                Utils.print("3. Release a Locker");
            }
            Utils.print("4. Quit");

            // Prompt for menu choice
            String choice = Utils.prompt("Please select an option by number: ");
            MenuService.MenuOption option = MenuService.MenuOption.menuChoice(choice);

            //Switch cases for Menu choices
            switch (option) {

                case RENT: // case 1: Rent a locker | Call rentLocker method
                    if (allLockersRented) { // In case user tries to enter 1 if menu option is not displayed
                        Utils.print("All lockers are rented. At least one locker must be released to rent a locker.");
                        break;
                    }
                    Result rent = lockerService.rentLocker();
                    Utils.print(rent.getMessage());
                    break;

                case ACCESS: // case 2: Access a locker | Call accessLocker method
                    if (!anyLockersRented) { // Check if any lockers are rented
                        Utils.print("\nNo lockers have been rented. Please rent a locker before attempting access.");
                        break;
                    }
                    String accessPin = Utils.prompt("\nTo access a locker, please enter your PIN: ");
                    Result access = lockerService.accessLocker(accessPin);
                    Utils.print(access.getMessage());
                    break;

                case RELEASE: // case 3: Release a locker |
                    if (!anyLockersRented) {
                        Utils.print("\nNo lockers have been rented. Please rent a locker before attempting a locker release.");
                        break;
                    }
                    String releasePin = Utils.prompt("\nTo release a locker, please enter your PIN: ");
                    Result release = lockerService.handleLockerRelease(releasePin);
                    Utils.print(release.getMessage());
                    break;

                case QUIT: // case 4: "q" to quit | Call print method
                    Utils.print("\nThanks for using the locker system by Lockdown Inc! Have great day!");
                    looping = false;
                    break;

                default: // Invalid input choice message via print method
                    Utils.print("\nInvalid choice. Please try again.");
            }
        }
    }
}
