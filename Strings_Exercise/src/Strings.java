public class Strings {
    public static void main(String[] args) {

    // Basic String Operations
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName + " " + lastName;

        // Print fullName.
        System.out.println("\n~*~*~Basic String Operations:~*~*~");
        System.out.println(fullName);

        // Find the length of fullName and print it.
        System.out.println("\nThere are " + fullName.length() + " letters in this name.");

        // Extract and print the first character using charAt(0).
        System.out.println("\nThe first letter of the name is: " + fullName.charAt(0));

        // Find the position of the letter 'r' in fullName using indexOf().
        System.out.println("\nThe first letter 'r' is in index: " + fullName.indexOf('r'));

    // Extracting Parts of a String
        String sentence = "LeArNiNg JaVa Is FuN!";
        //Extract and print:
        // "LeArNiNg" (characters 0 to 8).
        // "JaVa" (characters 9 to 13).
        // "FuN!" (last word using a single argument with substring())
        String firstWord = sentence.substring(0,8);
        String secondWord = sentence.substring(9,13);
        String thirdWord = sentence.substring(17,21);
        System.out.println("\n~*~*~Extracting Parts of a String:~*~*~");
        System.out.println("Extracted words: " + firstWord + ", " + secondWord +
                            ", " + thirdWord);

    // Splitting Strings
        String csvData = "apple,banana,grape,orange";

        // Use split() to break the string into an array
        String[] fruits = csvData.split(",");

        // Loop through the array and print each item
        System.out.println("\n~*~*~Splitting Strings~*~*~");
        System.out.print("~~Fruits~~");
        System.out.println("\n1. " + fruits[0] + "\n2. " + fruits[1] + "\n3. " + fruits[2]
                           + "\n4. " + fruits[3]);

    // Replacing Characters
        String sentence2 = "The quick brown fox.";

        // Replace "quick" with "slow", and replace all spaces with underscores
        System.out.println("\n~*~*~Replacing Characters:~*~*~");
        System.out.println(sentence2.replace(' ', '_').replace("quick", "slow"));

    // Handling Null and Empty Strings
        String blah = null;
        //Use an if statement to check if the string is null before printing its length
        System.out.println("\n~*~*~Handling Null and Empty Strings~*~*~");
        if (blah != null) {
            System.out.println("Length: " + blah.length());
        }
            else {
                System.out.println("Whoops! The string is null, cannot compute length!");


        }
    }
}
