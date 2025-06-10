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
    // 1) void addLockers(String lockerId): Adds a new locker to list
    public void addLockers(String lockerId) {
        for (int i = 0; i < lockers.size(); i++) { // Loop through indexes
            Locker currentIndex = lockers.get(i); // current locker index variable
            if (currentIndex.getLockerId().equals(lockerId)) { // If a lockerId match is found,
                System.out.println("That Locker ID is already taken."); // do not add locker
                return;
            }
        } else { // add locker
            lockers.add(new Locker(lockerId));

    }
    // 2) Locker getLocker


}
