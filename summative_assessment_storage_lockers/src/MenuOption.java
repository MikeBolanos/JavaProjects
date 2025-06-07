public enum MenuOption {
    RENT ("1"),
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
        return  INVALID;
    }
}
