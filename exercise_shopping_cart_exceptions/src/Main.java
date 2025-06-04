import java.util.Scanner;

public class Main {
    // Scanner instance
    private static final Scanner input = new Scanner(System.in);

    // Method to display list of choices
    private static void displayChoices(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i+1) + ". " + choices[i]);
        }
    }

    // Method to prompt user for a String
    private static String promptUserForString(String prompt) {
        System.out.println(prompt);
        return input.nextLine();
    }

    // Method to prompt user for an int
    private static int promptUserForInt(String prompt) {
        while (true) {
            try {

                System.out.println(prompt);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    public static void main(String[] args) {

        // Variables: Shipping and tax
        double taxRate = 0.07;
        double standardShipping = 2.00;
        double twoDayShipping = 5.00;
        double overnightShipping = 10.00;
        String validPromo = "FREE";
        double productPrice = 4.99;

        // Arrays to contain addresses and sizes
        String[] addresses = {"123 Sesame St.", "345 Downtha Rd.", "567 Old Potato Way"};
        String[] sizes = {"Small", "Medium", "Large"};


        // Order Confirmation Loop variable
        boolean isConfirmed = false;

        while (!isConfirmed) {

            // Collecting user input
            System.out.print("\n~*~*~Welcome to the shopping cart app!~*~*~\n");

            // Ask for shipping address:
            System.out.println("\nShipping address:");
            displayChoices(addresses);
            // Loop to prompt user for valid input
            int addressIndex = 0;
            while (addressIndex < 1 || addressIndex > addresses.length) {
                addressIndex = promptUserForInt("Enter your choice (1,2,3): ");
                if (addressIndex < 1 || addressIndex > addresses.length) {
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                }
            }


            // Ask for product size
            System.out.println("Sizes:");
            displayChoices(sizes);
            // Loop to prompt user for valid input
            int sizeIndex = 0;
            while (sizeIndex < 1 || sizeIndex > sizes.length) {
                sizeIndex = promptUserForInt("Enter size choice (1,2,3): ");
                if (sizeIndex < 1 || sizeIndex > sizes.length) {
                    System.out.println("Invalid size. Please choose 1, 2, or 3.");
                }
            }
            // Ask user for tax and shipping details
            String taxExempt = ("\nAre you tax-exempt? (y/n) ");
            String shipping = promptUserForString("Are you shipping? (y/n) ");
            int orderQuantity = 0;
            while (orderQuantity <= 0) {
                orderQuantity = promptUserForInt("Order Quantity? ");
                if (orderQuantity <= 0) {
                    System.out.println("Quantity must be more than 0");
                }
            }
            String promo = promptUserForString("Enter a promo code for free shipping if applicable: ");

            // Subtotal and discount
            double discount = 0.00;

            double subtotal = productPrice * orderQuantity;
            if (subtotal > 500) {
                discount = subtotal * 0.10;

            } else if (subtotal > 100) {
                discount = subtotal * 0.05;
            }
            double discountedTotal = subtotal - discount;

            // Apply tax if not exempt
            double tax = 0.0;
            if (!taxExempt.equalsIgnoreCase("y")) {
                tax = discountedTotal * taxRate;
            }

            // Shipping cost
            double shippingCost = 0.00;
            if (shipping.equalsIgnoreCase("y")) {
                String shippingType  = promptUserForString("Choose shipping type: (standard, two-day, overnight): ");

                if (shippingType.equalsIgnoreCase("standard")) {
                    if (promo.equalsIgnoreCase(validPromo)) {
                        shippingCost = 0.0;
                    } else {
                        shippingCost = standardShipping;
                    }

                } else if (shippingType.equalsIgnoreCase("two-day")) {
                    shippingCost = twoDayShipping;

                } else if (shippingType.equalsIgnoreCase("overnight")) {
                    shippingCost = overnightShipping;
                } else {
                    System.out.println("Invalid shipping type. Defaulting to standard shipping.");
                    shippingCost = standardShipping;
                }
            }

            // Output
            double grandTotal = discountedTotal + tax + shippingCost;

            System.out.println("\n~~~~ Order Summary ~~~~");
            System.out.println("Address:        " + addresses[addressIndex - 1]);
            System.out.println("Size:           " + sizes[sizeIndex - 1]);
            System.out.printf("%-15s $%.2f%n", "Subtotal:", subtotal);
            System.out.printf("%-15s -$%.2f%n", "Discount:", discount);
            System.out.printf("%-15s $%.2f%n", "Tax (7%):", tax);
            System.out.printf("%-15s $%.2f%n", "Shipping:", shippingCost);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.printf("%-15s $%.2f%n", "Grand Total:", grandTotal);

            // Order confirmation
            String confirm = promptUserForString("\nConfirm Order? (y/n): ");
            if (confirm.equalsIgnoreCase("y")) {
                isConfirmed = true;
                System.out.println("\nYour order has been confirmed.");
            } else {
                System.out.println("\nLet's try again.");
            }
        }
    }
}