import java.util.Scanner;

public class Main {
    // Scanner instance
    private static final Scanner input = new Scanner(System.in);

    // Method to display list of choices
    private static void displayChoices(String[] choices) {
        for (int i = 0; i < choices.length(); i++) {
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
        System.out.println(prompt);
        return Integer.parseInt(input.nextLine());
    }
    public static void main(String[] args) {

        // Variables: Shipping and tax
//        double taxRate = 0.07;
//        double standardShipping = 2.00;
//        double twoDayShipping = 5.00;
//        double overnightShipping = 10.00;
//        String validPromo = "FREE";
//        double productPrice = 4.99;
//        int productQuantity = 78;

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
            int addressIndex = promptUserForInt("Enter your choice (1,2,3): ");

            // Ask for product size
            System.out.println("Sizes:");
            displayChoices(sizes);
            sizeIndex = promptUserForInt("Enter size choice (1,2,3): ");

            String taxExempt = ("\nAre you tax-exempt? (y/n) ");
            String shipping = promptUserForString("Are you shipping? (y/n) ");
            int orderQuantity =promptUserForInt("Order Quantity? ");
            String promo = promptUserForString("Enter a promo code for free shipping if applicable: ");

            // Subtotal and discount
            double shippingCost = 0.00;
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
            if (shipping.equalsIgnoreCase("y")) {
                System.out.println("Choose shipping type: (standard, two-day, overnight): ");
                String shippingType = shopCart.nextLine();

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
            System.out.println("\nConfirm Order? (y/n): ");
            String confirm = shopCart.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                isConfirmed = true;
                System.out.println("\nYour order has been confirmed.");
            } else {
                System.out.println("\nLet's try again.");
            }
        }

    }
}
