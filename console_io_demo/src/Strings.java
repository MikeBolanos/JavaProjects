import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        // camel casing
        //String iceCream = "Mint chocolate chip";

        //String s2 = null;

        //System.out.println(s2.chars());
                            //Cannot invoke "String.chars()" because "s2" is null
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        String s1 = "house";
//        String s2 = "house";
//        String s3 = "house";
//        String s4 = new String("house");
//
//        System.out.println(s1.equals(s3));
//        System.out.println(s1.equals(s2));
//        System.out.println(s1 == s4);
//        System.out.println(s1.equals(s4));
        // always use .equals for string comparison, not ==
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        String s1 = "Sprocket";
//
//        int length = s1.length();
//        System.out.printf("The string %s has a length of %d.%n", s1, length);
//        // Length of a string,
//
//        int o =s1.indexOf('k');
//        System.out.printf("We found an 'k' at %d.%n", o);
//        // Strings have indexes
//
//        String name = "Joe Somebody";
//
//        int space = name.indexOf(' ');
//        String firstName = name.substring(0, 3);
//        System.out.printf(firstName);
        // Substring (spaces)

        String csv = "red.green.blue";
        String[] colors = csv.split(".");

        //       start index    condition       increment/decrement
        // for index, color in enumerate(colors) => Python version
        for (int i=0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }


    }

}

