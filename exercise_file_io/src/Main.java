import java.io.*;


public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("student_data.txt");

            if (file.createNewFile()) {
                System.out.println("\nstudent_data.txt created");
            } else {
                System.out.println("\nstudent_data.txt already exists");
            }
        } catch (IOException ex) {
            System.out.print("\nAn error occurred");
            ex.printStackTrace();
        }

        FileWriter writer;
        try {
            writer = new FileWriter("student_data.txt");
            writer.write("Alice, A\n");
            writer.write("Bob, B\n");
            writer.write("Charlie, A+\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter("student_data.txt", true );
             PrintWriter writer2 = new PrintWriter(fileWriter)) {
            writer2.println("David, B+");
            writer2.println("Eva, A");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("\nFile Contents:");

        try (FileReader fileReader = new FileReader("student_data.txt");
             BufferedReader reader = new BufferedReader(fileReader)) {

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("student_data.txt");

        System.out.println("\nAbsolute Path: " + file.getAbsolutePath());
        System.out.println("Relative path: " + file.getPath());

        File file3 = new File("student_data.txt");

        boolean success = file.delete();

        if (success) {
            System.out.println("\nstudent_data.txt was deleted");
        } else {
            System.out.println("\nstudent_data.txt was NOT deleted");
        }
    }
}


