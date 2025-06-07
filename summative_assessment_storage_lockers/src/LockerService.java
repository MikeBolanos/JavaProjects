import java.util.Random;

public class LockerService {
    // Use to generate random PINS
    private final Random random;

    // Array of all lockers
    private final Locker[] lockers;

    // Constructor
    // Sets up number of lockers in array
    public LockerService(int numberOfLockers) {
        lockers = new Locker[numberOfLockers + 1]; // Create locker space and shift array to exclude index 0.
        random = new Random(); // Create new random object

        // Put new lockers into array starting at 1
        for (int i = 1; i <= numberOfLockers; i++) {
            lockers[i] = new Locker(); // Start new lockers as available via Locker Constructor(?)***
        }
    }

    // Method to check if all lockers are rented
    public boolean lockersFull() {
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i].isAvailable()) {
                return false; // locker available!
            }
        }
        return true; // Lockers full (message?)***
    }

    // Method for PIN generator
    private String generatePin() {
        // variable to create random numbers from 0 to 9999
        int number = random.nextInt(10000);//(?)
        // return String formatted to lead with 0s ex: %04d(?)
        return String.format("%04d", number);
    }

    // Method to rent a locker
    public Result rentLocker() {
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i].isAvailable()) {
                String pin = generatePin(); // Variable for generated PIN
                lockers[i].setPin(pin);   // Store locker pin
                return new Result(true, "\nYou successfully rented Locker " + i + "! Your PIN is: " + pin);
            }            // ^^^ Calling Result to return tuple ^^^
        }
        return new Result(false, "\nNo lockers available at the moment!");
    }            // ^^^ Calling Result to return tuple ^^^

    // Method to check for valid PIN
    public boolean isPinValid(String pinInput) {
        for (int i = 1; i < lockers.length; i++) {
            if (!lockers[i].isAvailable() && lockers[i].isCorrectPin(pinInput)) {
                return true;
            }
        }
    }


    // Method to access a locker with correct PIN
    public Result accessLocker(String pinInput) {
        for (int i = 1; i < lockers.length; i++) {
            if (!lockers[i].isAvailable() && lockers[i].isCorrectPin(pinInput)) { // If locker is not available and matches the input PIN
                return new Result(true, "Access granted! Your locker: " + i + " is open."); //Access granted
            }
        }
        return new Result(false, "Access denied. Incorrect PIN or locker is not rented.");
    }
    // Method to release locker with correct PIN


}

