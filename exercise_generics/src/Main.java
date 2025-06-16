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


        // ArrayList Constructor
        ArrayList<Box<Integer>> boxes = new ArrayList<>();

        // Box objects in list
        Box<Integer> box1 = new Box<>();
        box1.setT(10);
        boxes.add(box1);

        Box<Integer> box2 = new Box<>();
        box2.setT(20);
        boxes.add(box2);

        Box<Integer> box3 = new Box<>();
        box3.setT(30);
        boxes.add(box3);

        // Print list using for loop:
        for (int i = 0; i < boxes.size(); i++) {
            Box<Integer> box = boxes.get(i);
            System.out.println("\nBox " + (i +1) + " contains: " + box.getT());
        }

        

    }
}


