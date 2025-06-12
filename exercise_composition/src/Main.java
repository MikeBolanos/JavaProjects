import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Prompts:
        // 1. Enter the name of a new Artifact.
        System.out.println("Enter the name of the artifact: ");
        String artifactName = scanner.nextLine();

        // 2. Enter the year of its discovery.
        System.out.println("Enter the year it was discovered: ");
        int Year = scanner.nextInt();
        scanner.nextLine();

        // 3. Enter the name and primary specialty of the discoverer.
        //First name
        System.out.println("Enter the first name of the discoverer: ");
        String discovererFirstName = scanner.nextLine();

        // Last name
        System.out.println("Enter the last name of the discoverer");
        String discovererLastName = scanner.nextLine();

        // Specialty
        System.out.println("Enter the primary specialty of the discoverer: ");
        String discovererPrimarySpecialty = scanner.nextLine();

        // 4. Ask whether the discoverer is also the curator.
        System.out.println("Is the discoverer also the curator? (Y/N): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("Y")) {
            
        }



    }
}
