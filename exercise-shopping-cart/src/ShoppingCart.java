public class ShoppingCart {
    public static void main(String[] args) {

        System.out.print("\nWelcome to the shopping cart app!\n");
        // Variables
        int productId = 1;
        int productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        int productQuantity = 78;

        // Calculate total cost of products in inventory
        double totalCost = productCost * productQuantity;
        System.out.print("\nTotal Cost: " + totalCost);

        // Calculate profit of product in dollars
        double profitPerProduct = productPrice - productCost;
        System.out.print("\nProfit in dollars: " + profitPerProduct);

        // Calculate total potential profit
        // total profit = profitPerProduct * productQuantity
        double totalProfit = profitPerProduct * productQuantity;
        System.out.println("\nTotal Profit: " + totalProfit);

    }
}
