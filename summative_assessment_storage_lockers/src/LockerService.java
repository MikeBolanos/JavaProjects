import java.util.Random;

public class LockerService {
    // Use to generate random PINS
    private Random random;

    // Array of all lockers
    private Locker[] lockers;

    // Constructor
    // Sets up number of lockers in array
    public LockerService(int numberOfLockers) {
        lockers = new Locker[numberOfLockers + 1]; // Create locker space, shifting array to ignore index 0
        random = new Random(); // Create new random object

        // Put new lockers into array starting at 1
        for (int i = 1; i < numberOfLockers; i++) {
            lockers[i] = new Locker(); // Start new lockers as available via Locker Constructor(?)
        }
    }

    // Method to check if all lockers are rented
    public boolean lockersFull() {
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i].isAvailable()) {
                return false; // locker available!
            }
        }
        return true; // Lockers full
    }

    // Method to rent a locker
    public String rentLocker() {
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i].isAvailable()) {
                String pin = generatePin();
            }
        }
    }
}

