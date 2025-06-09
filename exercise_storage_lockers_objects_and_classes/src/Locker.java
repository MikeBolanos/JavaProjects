public class Locker {

    // Attributes
    String lockerId;
    boolean isOccupied;
    String contents;

    public String getLockerId() {
        return lockerId;
    }

    public String getContents() {
        return contents;
    }

    // Constructor
    // Initialize locker with ID, set isOccupied to false, and contents to empty string
    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.isOccupied = false;
        this.contents = "";
    }
    // Methods

    // 1) Method void storeItem (String item): Stores an item in the locker, Sets isOccupied to True,
    // and updates contents.
    public void storeItem(String item) {
        this.contents = item;
        this.isOccupied = true;
    }


    // 2) Method void removeItem(): Empties a locker, sets isOccupied to false, and clears contents.
    public void removeItem() {
        this.contents = "";
        this.isOccupied = false;
    }

    // 3) Method String toString(): Returns a string representation of locker, including ID, occupancy statue,
    // and contents.
    public String toString() {
        String lockerStatus;
        if (isOccupied) {
            lockerStatus = "Occupied";
        } else {
            lockerStatus = "Available";
        }
        return "Locker ID: " + lockerId + " | Status: " + lockerStatus + " | Contents: " + contents + ".";
    }
}



