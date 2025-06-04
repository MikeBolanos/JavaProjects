import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = 0;
        String email = "";
        int pin = 0;

        try {
            // Validate age
            while (true) {
                System.out.print("Enter your age: ");
                String ageInput = scanner.nextLine();
                try {
                    age = Integer.parseInt(ageInput);
                    if (age < +0) {
                        System.out.println("Age must be a positive number. Try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age. Enter a number for age");

                }
            }
            // Validate email

            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (email == null || email.isEmpty()) {
                System.out.println("Email cannot be empty or blank");
                return;
            }
            // Validate PIN
            while (true) {

                System.out.print("Enter your 4-digit PIN: ");
                String pinInput = scanner.nextLine();
                try {
                    pin = Integer.parseInt(pinInput);
                    if (pin < 1000 || pin > 9999) {
                        System.out.println("PIN must be a 4-digit number. Try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid PIN. Please enter a 4-digit number.");
                }
            }

            System.out.println("\nRegistration Successful!");
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
            System.out.println("PIN: " + pin);

        } finally {
            System.out.println("\nRegistration Attempt Complete!");
        }
    }
}