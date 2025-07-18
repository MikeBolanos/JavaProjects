import java.lang.classfile.constantpool.ModuleEntry;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Declare an ArrayList<String> named students

        ArrayList<String> students = new ArrayList<String>();
        // Add at least five student names to the list using .add()
        students.add("Larry");
        students.add("Curly");
        students.add("Moe");
        students.add("Mike");
        students.add("Heather");

        // Use .get() to print the third student in the list
        System.out.println("\nThird student: " + students.get(2));

        // Remove the second student from the list using .remove()
        System.out.println("Removed student: " + students.remove(1));

        // Remove the second student from the list using .remove()
        System.out.println("Total remaining students: " + students.size());

        // Use .isEmpty() to determine if the list has students.
        // Print true if the list is empty, otherwise print false.
        System.out.println("List is empty: " + students.isEmpty());

        // Sort the list alphabetically using java.util.Collections.sort()
        java.util.Collections.sort(students);
        //Print the sorted list
        System.out.println("Sorted list: " + students);


    }
}
