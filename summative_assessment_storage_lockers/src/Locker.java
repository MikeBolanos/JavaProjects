public class Locker {
    //Variables:
    // String variable for PIN (null when empty)
    private String pin;

    // boolean variable for availability: isAvailable (true = locker is available, false = locker rented)
    private boolean isAvailable;

    // Constructor: Used when new locker created
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
    public void setPin(String newPin) {
        this.pin = newPin;
        this.isAvailable = false;
    }

    // 3) PIN comparison: - Is PIN correct? boolean(?)
                     // -If pinInput = stored PIN:
                            // - return true
                       // - Else : return false
    public boolean isCorrectPin(String pinInput) {
        if (this.pin == null)   {
            return false;
        }
        return this.pin.equals(pinInput);
    }

    // 4) Release locker: - Set isAvailable = true
                       // - set PIN to null(?)
    public void releaseLocker() {
        this.pin = null;
        this.isAvailable = true;
    }
}