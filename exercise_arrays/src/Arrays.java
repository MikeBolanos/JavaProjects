import java.util.Scanner;
import java.util.Random;

public class Arrays {
    public static void main(String[] args) {
        Scanner arrays = new Scanner(System.in);
        Random rand = new Random();


        // 1) Declare an array of 5 city names
        String[] cityNames = new String[5];
        cityNames[0] = "Austin";
        cityNames[1] = "Boston";
        cityNames[2] = "Denver";
        cityNames[3] = "Albany";
        cityNames[4] = "Columbus";

        //Print each city using its index:
        System.out.println(cityNames[0]);
        System.out.println(cityNames[1]);
        System.out.println(cityNames[2]);
        System.out.println(cityNames[3]);
        System.out.println(cityNames[4]);


        // 2) Update the 3rd city in the array to a different name
        cityNames[2] = "Phoenix";
        System.out.println("\nUpdated city names: ");
        for (int i = 0; i < cityNames.length; i++) {
            System.out.println(cityNames[i]);
        }


        // 3) Print the total number of cities in your array using .length
        System.out.println("\nThere are " + cityNames.length + " cities in this array.\n");


        // 4) Loop through the city names array using a for loop and print each city
        for (int i = 0; i < cityNames.length; i++) {
            System.out.println(cityNames[i]);
        }


        // 5) Use a for loop to print the city names in reverse order.
        System.out.println("\nReverse order:");
        for (int i = cityNames.length - 1; i >= 0; i--) {
            System.out.println(cityNames[i]);
        }

        //6 Ask the user to enter a city name.
        System.out.println("\nEnter a city name: ");
        String city = arrays.nextLine();

        //Check if city is in array
        boolean found = false;
        for (int i = 0; i < cityNames.length; i++) {
            if (cityNames[i].equalsIgnoreCase(city)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("City found!");
        } else {
            System.out.println("City not found!");
        }

        // 7) Create an array of 5 test scores.
        int[] testScores = {100, 74, 94, 88, 70};

        // Loop through the array and calculate the sum of all scores.
        int sum = 0;
        for (int i = 0; i < testScores.length; i++) {
            sum += testScores[i];
        }
        // Print the total
        System.out.println("\nThe sum of all test scores is: " + sum);


        // 8) Use a loop to find the highest and lowest test score in the array.
        int highest = testScores[0];
        int lowest = testScores[0];

        for (int i = 0; i < testScores.length; i++) {
            if (testScores[i] > highest) {
                highest = testScores[i];
            }
            if (testScores[i] < lowest) {
                lowest = testScores[i];
            }
        }
        // Print both values.
        System.out.println("\nThe highest score is " + highest);
        System.out.println("The lowest score is " + lowest);


        // 9) Compute and print the average score.
        double average = (double) sum / testScores.length;
        System.out.println("\nThe average of the test scores is " + average);


        // 10) Create an array of 10 random numbers between 1 and 5.
        int[] numbers = new int[10];
        System.out.println("\nArray: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(5) + 1;
            System.out.println(numbers[i] + " ");
        }
        // Count how many times the number 3 appears in the array
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 3) {
                count++;
            }
        }
        System.out.println("\nThe number 3 appears " + count + " times.");



        // 11) Given an array {1, 2, 3, 4, 5}
        int [] numbers2 = {1, 2, 3, 4, 5};

        // modify it so that the first element moves to the last position.
        int placeZero = numbers2[0];

        // The remaining elements shift one step left.
        for (int i = 0; i < numbers2.length -1; i++) {
            numbers2[i] = numbers2[i + 1];
        }
        // Moved this line to go after the shift, as the last index must be manually added.
        numbers2[numbers2.length - 1] = placeZero;
        System.out.print("\nShifted array elements: ");
        for (int num : numbers2) {
            System.out.print(num + " ");
        }


        // 12) Create an array of 6 student names:
        String [] students = {"Mike", "Heather", "Vincent", "Andre", "Kayla", "Chelsea"};

            //Check for duplicates with nested loops
        boolean duplicates = false;
        for (int i = 0; i < students.length; i++) {
            for (int d = i + 1; d < students.length; d++) {
                if (students[i].equalsIgnoreCase(students[d])) {
                    duplicates = true;
                    break;
                }
            }
            if (duplicates) {
                break;
            }
        }
        if (duplicates) {
            System.out.println("\nDuplicates found!");
        } else {
            System.out.println("\nNo duplicates found.");
        }


        // 13) Mini Address Book
            // Create 3 arrays: names, phone numbers, and emails
        String[] contacts = {"Mike", "Heather", "Megan"};
        String[] phoneNums = {"512-459-2222", "123-456-7890", "098-765-4321"};
        String[] email = {"mike@fake.com", "heather@fake.com", "megan@fake.com"};

            // Ask user for a name
        System.out.println("\nEnter a name: ");
        String name = arrays.nextLine();

        boolean foundName = false;

            // Search for name
        for (int i = 0; i <contacts.length; i++) {
            if (contacts[i].equalsIgnoreCase(name)) {
                System.out.println("\nPhone #: " + phoneNums[i]);
                System.out.println("Email: " + email[i]);
                foundName = true;
                break;
            }
        }
            // If name not found
        if (!foundName) {
            System.out.println("\nContact not found.");
        }
    }
}
