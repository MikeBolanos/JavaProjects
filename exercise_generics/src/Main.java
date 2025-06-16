import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Box that stores an Integer
        Box<Integer> integerBox = new Box<>();
        integerBox.setT(100);
        System.out.println("\nNumber Box contains: " + integerBox.getT());

        // Create an instance of Box that stores a String

        Box<String> stringBox = new Box<>();
        stringBox.setT("Hello, Generics!");
        System.out.println("Message Box contains: " + stringBox.getT());

    }

        // ArrayList Constructor
      ArrayList<Box<Integer>> boxes = new ArrayList<>();





}


