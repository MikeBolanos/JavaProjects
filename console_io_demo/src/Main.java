import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        // Type Name    Initialize / Assign
        Scanner io = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = io.nextLine();
        System.out.print("Enter your favorite movie: ");
        String movie = io.nextLine();


        System.out.println("Hello, " + name);
        System.out.println("Your favorite movie is: " + movie);

        System.out.print("Enter your age: ");
        //              (int()
        int age = Integer.parseInt(io.nextLine());
        System.out.println("You are " + age + " years old.");

        System.out.printf("%s, you are %d years old. Your favorite movie is %s.", name, age, movie);
                        //String    //Int (d == digit)                    //String

        // %d integers (Whole number)
        // %f floating point (double, float)
        // %s string
        // %c character
        // %b booleans
        // %x hexadecimal
        // %e scientific
        // %n new line
        // |%"num"s| right align
        // |%-"num"s| left align
        System.out.print("Enter the price: ");
        double price = Double.parseDouble(io.nextLine());
        System.out.printf("The total price is: $5.2f", price);

        int upc = 1283;
        System.out.printf("Bar code: %010d%" , upc);
                                    // zero padding, but the symbols mean total digits,
                                   //   so 10 would be 10 total digits
                                    // (puts zeros in front of number until 10 total digits print)




    }
}
