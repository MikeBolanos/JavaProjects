public class ShoppingCartEnums {
    enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED
    }
    enum ShippingStatus {
        STANDARD,
        TWO_DAY,
        OVERNIGHT

    }

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
        System.out.println(ShippingStatus.STANDARD);
        System.out.println(ShippingStatus.TWO_DAY);
        System.out.println(ShippingStatus.OVERNIGHT);
        ShippingStatus shipStatus = ShippingStatus.TWO_DAY;
        System.out.println("Ship Status: " + shipStatus);

        System.out.println(OrderStatus.PENDING);
        System.out.println(OrderStatus.PROCESSING);
        System.out.println(OrderStatus.SHIPPED);
        System.out.println(OrderStatus.DELIVERED);
        OrderStatus orderStatus = OrderStatus.PROCESSING;
        System.out.println("Order Status: " + orderStatus);

    }
}
