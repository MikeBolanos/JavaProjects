import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LockerManager service = new LockerManager();

        boolean looping = true;

        while (looping) {
            // Menu options
            System.out.println("\n~*~*~Locker Service Main Menu~*~*~");
            System.out.println("1. Add locker ID");
            System.out.println("2. Remove locker ID");
            System.out.println("3. Store item");
            System.out.println("4. Retrieve item");
            System.out.println("5. Display all lockers");
            System.out.println("6 Exit");
            System.out.println("Please enter the number of your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // add locker
                    System.out.println("\nEnter an ID to add locker");
                    String newId = scanner.nextLine();
                    service.addLocker(newId);
                    break;

                case 2: // remove locker
                    System.out.println("\nEnter a locker ID to remove");
                    String removeId = scanner.nextLine();
                    service.removeLocker(removeId);
                    break;

                case 3: // Store item
                    System.out.println("Enter a locker ID to store an item");
                    String storeId = scanner.nextLine();
                    Locker storeLocker = service.getLocker(storeId);
                    if(storeLocker == null) { // Check if locker ID input will return anything.
                        System.out.println("Locker ID not found.");
                    } else {
                        System.out.println("Enter an item to store in the locker: ");
                        String item = scanner.nextLine();
                        storeLocker.storeItem(item);// Store item in Locker, isOccupied is true
                    } break;


                case 4: // Retrieve item
                    System.out.println("Enter a locker ID to retrieve an item");
                    String retrieveId = scanner.nextLine();
                    Locker retrieveLocker = service.getLocker(retrieveId);

                case 5: // Display lockers
                    service.displayAllLockers();
                    break;

                case 6: //Exit
                    looping = false;
                    break;
            }

        }
        System.out.println("\nThank you for using the Locker Service System!");
    }

}


