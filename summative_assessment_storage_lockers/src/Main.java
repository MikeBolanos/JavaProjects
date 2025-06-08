public class Main {
    public static void main(String[] args) {
        // New LockerService (will create new collection of lockers with chosen amount)
        LockerService lockerService = new LockerService(5);

        // Call MenuHandler with the created lockerService
        MenuHandler menuHandler = new MenuHandler(lockerService);

        // Start loop from MenuHandler
        menuHandler.menuLoop();
    }
}

