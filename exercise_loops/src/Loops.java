import java.util.Scanner;
import java.util.Random;
public class Loops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();


        //Counting from 1 to 100
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
        // Count in only evens
        for (int i = 2; i <= 100; i += 2) {
            System.out.println("\n" + i);
        }


        // Countdown using user input for starting number and print Blast Off when reaching 0
        System.out.println("Enter a starting number to countdown from: ");
        int countdown = Integer.parseInt(input.nextLine());

        while (countdown > 0) {
            System.out.println(countdown);
            countdown--;
        }
        System.out.println("Blast Off!");


        // Guess the number between 1 and 50 and keep looping with do-while
        int targetNum = rand.nextInt(50) + 1;
        int guess;
        do {
            System.out.println("Guess a number between 1 and 50: ");
            guess = Integer.parseInt(input.nextLine());
            if (guess < targetNum) {
                System.out.println("Too low! Guess again!");
            } else if (guess > targetNum) {
                System.out.println("Too high! Guess again!");
            }
        } while (guess != targetNum);
        // Correct guess
        System.out.print("Huzzah! You guessed the number!");


        //Multiplication Table:
        // Ask user for a number
        System.out.println("Enter a number to see its multiplication table: ");
        int num2 = Integer.parseInt(input.nextLine());
        // Print table from 1 to 10
        System.out.println("\nMultiplication Table for " + num2 + ":");
        for (int i2 = 1; i2 <= 10; i2++) {
            int result = num2 * i2;
            System.out.println(num2 + " * " + i2 + " = " + result);
        }


        // Password Validator while loop
        String password = "letmein";
        String userPassword;

        // Ask for password until correct
        System.out.print("Enter Password: ");
        userPassword = input.nextLine();

        while (!userPassword.equals(password)) {
            System.out.println("Nah-ah-ah! You didn't say the magic word! Try again");
            System.out.println("Enter Password: ");
            userPassword = input.nextLine();
        }
        System.out.println("Access granted!");


        //Find the first vowel loop
        //Ask user for a word
        System.out.println("Enter a word: ");
        String word = input.nextLine();

        boolean foundVowel = false;

        // Loop through letters in the word
        for (int i3 = 0; i3 < word.length(); i3++) {
            char letter = word.charAt(i3);
            // Vowel check
            if (letter == 'A' || letter == 'a' || letter == 'E' || letter == 'e' ||
                    letter == 'I' || letter == 'i' || letter == 'O' || letter == 'o' ||
                    letter == 'U' || letter == 'u') {

                System.out.println("First vowel (" + letter + ") found at position " + (i3 + 1) + ".");
                foundVowel = true;
                break;
            }


            // ATM System Do-while loop
            double balance = 500.00;
            int choice;

            do {
                // menu
                System.out.println("\n~~~ATM Menu~~~");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.println("Enter your choice: (1-4): ");

                choice = input.nextInt();

                if (choice == 1) {
                    System.out.println("Enter amount to withdraw: ");
                    double amount = input.nextDouble();

                    if (amount <= balance) {
                        balance -= amount;
                        System.out.println("New balance: $" + balance);
                    } else {
                        System.out.println("Insufficient Funds");
                    }
                } else if (choice == 2) {
                    System.out.println("Enter amount to deposit: ");
                    double amount = input.nextDouble();
                    balance += amount;
                    System.out.println("New balance: " + balance);
                } else if (choice == 3) {
                    System.out.println("Current balance: $" + balance);
                } else if (choice == 4) {
                    System.out.println("Good bye");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);


            // Fizzbuzz
            // Print 1 - 100
            for (int i4 = 1; i4 <= 100; i4++) {
                // divisible by 3 or 5
                if ((i4 % 3 == 0) && (i4 % 5 == 0)) {
                    System.out.println("FizzBuzz");
                    // divisible by 3
                } else if (i4 % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i4 % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i4);
                }
            }


            // Reverse a String (For Loop)
            // Ask user for a word
            System.out.println("Enter a word");
            String word2 = input.nextLine();
            System.out.println("Reversing...");
            // for loop to print word in reverse
            for (int i5 = word2.length() - 1; i5 >= 0; i5--) {
                System.out.println(word2.charAt(i5));
            }


            // Prime number check (while loop)
            // Ask use for a number
            System.out.println("Enter a number to check if it's a prime number: ");
            int num3 = input.nextInt();

            boolean isPrime = true;

            if (num3 < 1) {
                isPrime = false;
            } else {
                int i = 2;
                while (i <= num3 / 2) {
                    if (num3 % i == 0) {
                        isPrime = false;
                        break;
                    }
                    i++;
                }
            }
            // Result
            if (isPrime) {
                System.out.println(num3 + " is a prime number");
            } else {
                System.out.println(num3 + " is not a prime number");
            }


            // Word Counter (For loop with Split)
            // Ask user for a sentence
            System.out.println("Enter a sentence: ");
            String sentence = input.nextLine();

            // Split sentence into words using spaces as a separator
            String[] words = sentence.split(" ");

            // Count number of words using a for loop
            int count2 = 0;
            for (int i = 0; i < words.length; i++) {
                if (!words[i].isEmpty()) { // skips empty strings in case of double/extra spaces
                    count2++;
                }
            }
            System.out.println("Number of words in this sentence: " + count2);
            }
        }
    }