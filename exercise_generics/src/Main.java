import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

        // Create a Queue that holds Box<String> objects
        // Queue Constructor
        Queue<Box<String>> queueBox = new LinkedList<>();

        // Add 3 box objects to queue
        Box<String> box1st = new Box<>();
        box1st.setT("First in line");
        queueBox.add(box1st);

        Box<String> box2nd = new Box<>();
        box2nd.setT("Second in line");
        queueBox.add(box2nd);

        Box<String> box3rd = new Box<>();
        box3rd.setT("Third in line");
        queueBox.add(box3rd);


        // Counter variable to print Box 1, Box 2, etc
        
        // Print queue
        System.out.println("\nProcessing queue...");
        while (!queueBox.isEmpty()) {
            Box<String> box = queueBox.poll();
            System.out.println("Queue Box " +
        }

    }
}


