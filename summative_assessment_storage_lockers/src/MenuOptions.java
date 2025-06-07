public enum MenuOptions {
    RENT ("1"),
    ACCESS("2"),
    RELEASE("3"),
    QUIT("4"),
    INVALID("");


    // Variable to store user input for option
    private final String choice;

    // Constructor
    MenuOptions(String choice) {
        this.choice = choice;
    }

    // Method for menu options

}
