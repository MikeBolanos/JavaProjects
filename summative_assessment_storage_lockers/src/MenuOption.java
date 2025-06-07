public enum MenuOption {
    RENT ("1"),
    ACCESS("2"),
    RELEASE("3"),
    QUIT("4"),
    INVALID("");


    // Variable to store user input for option
    private final String choice;

    // Constructor
    MenuOption(String choice) {
        this.choice = choice;
    }

    // Method for menu options
    public static MenuOption menuOption(String input) {
        input = input.trim(); // initialize input
        if (input.equals("1")) {
            return RENT;
        }else if (input.equals("2")) {
            return  ACCESS;
        }else if (input.equals("3")) {
            return RELEASE;
        }else if (input.equals("4")) {
            return QUIT;
        }else {
            return INVALID;
        }
    }
}
