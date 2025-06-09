public class Main {
    public static void main(String[] args) {
        // New LockerService (will create new collection of lockers with chosen amount)
        LockerService lockerService = new LockerService(30);

        // Call MenuHandler with the created lockerService
        MenuService menuHandler = new MenuService(lockerService);

        // Start loop from MenuHandler
        menuHandler.menuLoop();
    }
}

