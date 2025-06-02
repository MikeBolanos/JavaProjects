import java.util.Scanner;

public class TextAdventureLoops {
    public static void main(String[] args) {
        Scanner adventure = new Scanner(System.in);
        System.out.println("Welcome to the Three Doors!");
        boolean keepLooping = true;
        boolean key1 = false;
        boolean key2 = false;
        String mainRoom = "\nYou are in a large room with three doors:" +
                        "\n1. The full brass door" +
                        "\n2. The shiny steel door" +
                        "\n3. The golden door" +
                        "\nWhich door do you choose to enter? (1,2,3) or (q to quit): ";

        String room1 = "\nYou push the brass door open, revealing a small aquatic-themed library. On a side table, you see a book with half a key being used as a bookmark. You found half of a key!";
        String room1Seen = "\nYou go through the brass door again. You find nothing else in the library.";
        String room2 = "\nYou use all your might to push open the shiny steel door. You see a room full of medieval weapons displayed on the walls and in cases and racks. You find another half of a key on one of the weapon racks!";
        String room2Seen = "\nYou go through the steel door again. You admire the many weapons, but there aren't any more half-keys.";
        String room3Locked = "\nYou attempt to open the golden door, but it won't open. You notice a keyhole the other doors do not have...";
        String room3Unlocked = "\nYou combine the two keys halves and use it to unlock the golden door. When you open it, you find... the exit!";

        while (keepLooping) {
            System.out.print(mainRoom);
            String choice = adventure.nextLine();
            switch (choice) {
                case "1":
                    if (key1) {
                        System.out.println(room1Seen);
                    } else {
                        key1 = true;
                        System.out.println(room1);
                    }
                    break;

                case "2":
                    if (key2) {
                        System.out.println(room2Seen);
                    } else {
                        key2 = true;
                        System.out.println(room2);
                    }
                    break;
                case "3" :
                    if (key1 && key2) {
                        System.out.println(room3Unlocked);
                        keepLooping = false;
                    } else {
                        System.out.println(room3Locked);
                    }
                    break;
                case "q" :
                    keepLooping = false;
                    break;
                default :
                    System.out.println("\nYou seem distracted by the decor of each door; try choosing again.");
            }
        }
        System.out.println("\nThanks for playing the Three Doors!");
    }
}
