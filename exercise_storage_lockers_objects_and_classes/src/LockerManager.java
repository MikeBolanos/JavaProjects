import java.util.ArrayList;

public class LockerManager {
    // Attributes

    // lockers (ArrayList<Locker>): A list to store multiple Locker objects
    private ArrayList<Locker> lockers;

    // Constructor
    // LockerManager(): Initializes list of lockers
    public LockerManager() {
        lockers = new ArrayList<>();
    }
    // Methods
    // 1) void addLocker(String lockerId): Adds a new locker to list
    public void addLocker(String lockerId) {
        for (int i = 0; i < lockers.size(); i++) { // Loop through indexes
            Locker currentIndex = lockers.get(i); // current locker index variable
            if (currentIndex.getLockerId().equals(lockerId)) { // If a lockerId match is found,
                System.out.println("That Locker ID is already taken."); // do not add locker
                return;
            }
        }
        lockers.add(new Locker(lockerId)); // add locker with locker ID if no matches found
        System.out.println("Locker " + lockerId + " added!");

    }
    // 2) Locker getLocker(String lockerId): Retrieves a locker by its ID
    public Locker getLocker(String lockerId) {
        for (int i = 0; i < lockers.size(); i++) {
            Locker currentIndex = lockers.get(i);
            if (currentIndex.getLockerId().equals(lockerId)) {
                return currentIndex;
            }
        }
        return null;
    }


    // 3) void removeLocker(String lockerId): Removes a locker from the list by its ID
    public void removeLocker(String lockerId) {
        Locker removingLocker = getLocker(lockerId);
        if (removingLocker == null) {
            System.out.println("Locker ID not found");
            return;
        }
        lockers.remove(removingLocker);
        System.out.println("Locker " + lockerId + " removed!");
    }

    // 4) void displayAllLockers(): Displays info for all lockers
    public void displayAllLockers() {

    }
}
