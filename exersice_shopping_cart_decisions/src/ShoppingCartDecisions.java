import java.util.Scanner;

public class ShoppingCartDecisions {


    public static void main(String[] args) {


        Scanner shopCart = new Scanner(System.in);

        // Variables: Shipping and tax
        double taxRate = 0.07;
        double standardShipping = 2.00;
        double twoDayShipping = 5.00;
        double overnightShipping = 10.00;
        String validPromo = "FREE";
        double productPrice = 4.99;
        int productQuantity = 78;

        // Collecting input from user
        System.out.print("\n~*~*~Welcome to the shopping cart app!~*~*~\n");
        System.out.println("\nAre you tax-exempt? (y/n) ");
        String taxExempt = shopCart.nextLine();
        System.out.println("Are you shipping? (y/n) ");
        String shipping = shopCart.nextLine();
        System.out.println("Order Quantity? ");
        int orderQuantity = Integer.parseInt(shopCart.nextLine());
        System.out.println("Enter a promo code for free shipping if applicable: ");
        String promo = shopCart.nextLine();


        // Subtotal
        double shippingCost = 0.00;
        double discount = 0.00;

        double subtotal = productPrice * orderQuantity;
        if (subtotal > 500) {
            discount = subtotal * 0.10;

        }else if ( subtotal > 100) {
            discount = subtotal *0.05;
        }

        double discountedTotal = subtotal - discount;

        // Apply tax if not exempt
        double tax = 0.0;
        if (!taxExempt.equalsIgnoreCase("y")) {
            tax = discountedTotal *taxRate;
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
        System.out.printf("%-15s $%.2f%n", "Subtotal:", subtotal);
        System.out.printf("%-15s -$%.2f%n", "Discount:", discount);
        System.out.printf("%-15s $%.2f%n", "Tax (7%):", tax);
        System.out.printf("%-15s $%.2f%n", "Shipping:", shippingCost);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-15s $%.2f%n", "Grand Total:", grandTotal);
    }
}