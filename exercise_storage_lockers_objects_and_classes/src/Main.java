import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LockerManager service = new LockerManager();

        boolean looping = true;

        while (looping) {
            // Menu options
            System.out.println("\n~*~*~*~Locker Service Main Menu~*~*~*~");
            System.out.println("\n 1. Add locker ID");
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
                    System.out.println("Enter an ID to add locker");
                    String newId = scanner.nextLine();
                    service.addLocker(newId);
                    break;

                case 2: // remove locker
                    System.out.println("Enter a locker ID to remove");
                    String removeId = scanner.nextLine();
                    service.removeLocker(removeId);
                    break;
            }
                


        }

    }

}
