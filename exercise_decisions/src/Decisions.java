import java.util.Scanner;

public class Decisions {
    public static void main(String[] args) {
        Scanner decisions = new Scanner(System.in);

        // 1. Welcome the player and explain the scenario
        System.out.println("\n~*~*~*~ Welcome to the Lair of the Sinister Shade! ~*~*~*~");

// - Print an introduction message
        System.out.println("\nYou stand before a dank, dark cave carved into the mountainside, rumored to be the lair of a Shade, a demon, hoarding magical artifacts.\n");
// - Ask if they want to enter the cave
// - Get user input (yes/no)
        System.out.println("Do you dare to enter the cave? (yes/no): ");
        String enterCave = decisions.nextLine();
        if (enterCave.equalsIgnoreCase("yes")) {
            // 2. If they enter, present two path choices (left or right)
            System.out.println("You walk cautiously into the wide maw. Before you lie two paths: One to your left and another to your right. Which way do you go? (left/right): ");
            String pathChoice = decisions.nextLine();
            // - Use an if-else statement to process the decision
            // - If they go left, introduce an obstacle or creature
            if (pathChoice.equalsIgnoreCase("left"))
            {
                System.out.println("You head left. The light fades, and you encounter a shadowy figure. It's the Shade!");

                // 3. If they go left, ask if they want to fight or flee
                // - Use a nested if statement to handle the fight scenario
                System.out.println("Do you fight or flee? (fight/flee): ");
                String actionChoice = decisions.nextLine();

                // - If they fight, print a success/failure message
                if (actionChoice.equalsIgnoreCase("fight")) {
                    System.out.println("You charge at the Shade. You fight fiercely, finally banishing it! You are severely injured, but you saved the Kingdom of Keoland from the Shade!");

                    // - If they flee, print a message that they barely escaped
                } else if (actionChoice.equalsIgnoreCase("flee")) {
                    System.out.println("You immediately turn and sprint to the cave entrance, feeling dark tendrils whip at your heels. Sunlight hits your face as you barely escape the Shade.");
                } else {
                    System.out.println("Invalid choice. The Shade takes advantage of your hesitation and envelops you in darkness. You disappear into a void, never to be seen again...");

                }
    }   else if (pathChoice.equalsIgnoreCase("right")) {
                System.out.println("Heading right, you stumble upon a hidden chamber with a cracked altar holding three magical artifacts: A glowing chunk of smokey quartz, a silky cape, and a pair of steel gauntlets.");
                System.out.println("Choose one artifact to take (quartz, cape, gauntlets): ");
                String artifactChoice = decisions.nextLine();
                // present a switch menu with artifact choices
                // Use a switch statement to determine the outcome of their choice
                switch (artifactChoice.toLowerCase()) {
                    case "quartz":
                        System.out.println("You grab the stone. Light from within it pulses with swirling mist. You gain the power of clairvoyance! You know where the Shade will be at all times." +
                                "You leave the cave easily, laughing as the demon curses at your evasions!");
                        break;
                    case "cape":
                        System.out.println("You take the cape and put it on. Wait where did you go?! You're invisible! The Shade appears and searches for your, but it can't find you." +
                                "You escape the cave with your magical artifact, ready to start your next adventure: a heist!");
                        break;
                    case "gauntlets":
                        System.out.println("You slip the gauntlets on and feel magical energy swell in your muscles. You now have the strength of three warriors! You hear the Shade enter the chamber" +
                                "You fight the demon and tear the thing's flesh apart like fabric, banishing it to the Abyss. The Kingdom of Keoland is safe once more.");
                        break;
                    // 5. Handle invalid inputs with a default response
                    default:
                        System.out.println("You attempt to take more than one artifact. They all disappear, you feel a heavy darkness fall over you. Your memories fade into a void, and you become a controllable husk. The Shade has you now. ");
                        break;
                }
        } else {
                System.out.println("You become distracted by a menacing growl in the darkness and step on a false floor, falling into a pit of spikes and other careless adventurers. This ends your adventure.");


            }


    }   else if (enterCave.equalsIgnoreCase("no")) {
                System.out.println("You decide it's not worth the trouble. You turn away from the cave to walk back towards the the Kingdom of Keoland, daydreaming of what might have been...");
    }   else {
                System.out.println("As you stand there, hesitating, a rogue boulder rolls down the mountain and SPLAT! Your adventure ends before it could begin.");
        }

        // Thank the player for playing
        System.out.println("\n~*~*~*~ Thank you for playing The Lair of the Sinister Shade! ~*~*~*~");


    }
}