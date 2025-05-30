import java.util.Scanner;

public class ConsoleIo {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("\n~*~Welcome to the order form!~*~");
        System.out.println("What is your name?: " );
        String name = io.nextLine();
        System.out.println("Hello, "+ name +"! Let's start that order.");
        System.out.println("\nWhat would you like to purchase? ");
        String item = io.nextLine();
        System.out.println("\nYou chose: " + item);
        System.out.println("\nHow many are you purchasing? ");
        int count = Integer.parseInt(io.nextLine());
        System.out.println("\nQuantity desired: " + count);
        System.out.print("\nWhat is the price of the item? ");
        double price = Double.parseDouble(io.nextLine());
        System.out.printf("\nItem price: $%.2f\n", price );
        double subTotal = price * count;
        double tax = subTotal * 0.07;
        double grandTotal = subTotal + tax;
        System.out.println("\n      Your Order");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-15s %s%n", "Item:", item);
        System.out.printf("%-15s %d%n", "Quantity:", count);
        System.out.printf("%-15s $%.2f%n", "Unit Price:" , price);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("%-15s $%.2f%n", "Subtotal:", subTotal);
        System.out.printf("%-15s $%.2f%n", "Tax (7%):", tax);
        System.out.printf("%-15s $%.2f%n", "Grand Total:", grandTotal);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nThanks for shopping, " + name + "!");







    }
}
