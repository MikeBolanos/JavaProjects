public class Result {
    // Variables (set to final, so they cannot change
    private final boolean success;
    private final String message;

    // Constructor
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    // Getter for success
    public boolean getSuccess() {
        return success;
    }
    // Getter for message
    public String getMessage() {
        return message;
    }
}