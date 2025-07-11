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
        int year = scanner.nextInt();
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

        // Created new discoverer Person object with info provided
        Person discoverer = new Person(discovererFirstName, discovererLastName, discovererPrimarySpecialty);

        // 4. Ask whether the discoverer is also the curator.
        System.out.println("Is the discoverer also the curator? (Y/N): ");
        String response = scanner.nextLine();

        // Need curator variable to use in if statement
        Person curator;

        // 5. If the user answers N for #4, enter the name and primary specialty of the curator
        if (response.equalsIgnoreCase("Y")) {
            curator = discoverer; // If "Yes" curator is the discoverer

        } else { // Otherwise ask for curator info: first name, last name, primary specialty
            System.out.println("Enter the first name of the curator: ");
            String curatorFirstName = scanner.nextLine();

            System.out.println("Enter the last name of the curator: ");
            String curatorLastName = scanner.nextLine();

            System.out.println("Enter the primary specialty of the curator: ");
            String curatorPrimarySpecialty = scanner.nextLine();

            // Created new curator Person object with info provided
            curator = new Person(curatorFirstName, curatorLastName, curatorPrimarySpecialty);
        }

        // Created the Artifact object with all info provided
        Artifact artifact = new Artifact(artifactName, year, discoverer, curator);

        // Artifact report
        System.out.println("\n~*~*~Artifact Report~*~*~");
        System.out.println(artifact);
    }
}
