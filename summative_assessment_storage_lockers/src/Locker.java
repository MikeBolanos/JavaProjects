
public class Locker {
    //Variables:
    // String variable for PIN (null when empty) ex: (private?) String pin = null
    private String pin;

    // boolean variable for availability: isAvailable (true = locker is empty, false = locker being used)
    private boolean isAvailable;

    // Constructor: Used when new locker created(?)
    // - Set PIN to new pin? or null?
    public Locker() {
        this.pin = null;
        this.isAvailable = true;
    }

    // Methods:

    // 1) Availability: check if locker isAvailable = true/false
    public boolean isAvailable() {
        return this.isAvailable;
    }

    // 2) Rent locker: - Set PIN for locker
                    // - Set isAvailable = false(?)
    public void rentLocker(String newPin) {
        this.pin = newPin;
        this.isAvailable = false;
    }

    // 3) PIN validation: - Is PIN correct? boolean(?)
                     // -If pinInput = stored PIN:
                            // - return true
                       // - Else : return false
    public boolean isValidPin(String pinInput) {
        if (this.pin == null)   {
            return false;
        }

        if (this.pin.equals(pinInput)) {
            return true;
        } else {
            return false;
        }
    }


    // 4) Release locker: - Set isAvailable = true
                       // - set PIN to null(?)
    public void releaseLocker() {
        this.pin = null;
        this.isAvailable = true;
    }
}