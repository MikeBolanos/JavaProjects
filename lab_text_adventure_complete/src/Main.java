import java.util.Scanner;

public class Main {
    public static void print(String message) {
        System.out.println(message);
    }
    public static String promptString(String message) {
        Scanner adventure = new Scanner(System.in);
        print(message);
        return adventure.nextLine();
    }

    public static void keyAndRoomsText(String[] rooms, String[] seenRooms, boolean[] keys, int door) {
        if (keys[door] == true) {
            print(seenRooms[door]);
        } else {
            print(rooms[door]);
            keys[door] = true;
        }
    }

    public static void main(String[] args) {
        // Welcome and name prompt
        print("Welcome to the Five Doors!"); // Call print method
        String name = promptString("What is your name?:  "); // Call prompt method
        print("Hello, " + name + "!"); // Call print method

        // Variables
        boolean keepLooping = true;
        String[] rooms = new String[5];
        String[] seenRooms = new String[5];
        boolean[] keys = new boolean[4];


        String mainRoom = """
                
                You are in a large room with three doors:\
                
                1. The full brass door\
                
                2. The shiny steel door\
                
                3. The silver door\
                
                4. The copper door\
                
                5. The golden door\
                
                Which door do you choose to enter? (1, 2, 3, 4, 5):\s""";

        // Arrays of choice returns
        rooms[0] = "\nYou push the brass door open, revealing a small aquatic-themed library. On a side table, you see a book with a brass key being used as a bookmark. You take the key";
        rooms[1] = "\nYou use all your might to push open the shiny steel door. You see a room full of medieval weapons displayed on the walls and in cases and racks. You find a steel key hanging on one of the weapon racks!";
        rooms[2] = "\nThe silver door slides to the side, into the wall, and you find a large taxidermy werewolf! Around its neck is a silver key on a cord. You carefully claim the key.";
        rooms[3] = "\nYou push open the copper door and reveal a room filled with piles of copper currencies old and new. You search a few piles and finally find a copper key!";
        rooms[4] = "\n You attempt to open the golden door, but it won't open. You notice four keyholes the other doors do not have...";

        seenRooms[0] = "\nYou go through the brass door again. You find nothing else in the library.";
        seenRooms[1] = "\nYou go through the steel door again. You admire the many weapons, but there aren't any more keys.";
        seenRooms[2] = "\nYou go through the silver door again. Did the stuffed werewolf move? No... of course not. You leave quickly.";
        seenRooms[3] = "\nYou go through the copper door again. Somehow the piles are now in ordered stacks. Nothing else is new.";
        seenRooms[4] = "\nYou insert all four keys and unlock the golden door. When you open it, you find... the exit!";

        while (keepLooping) {
            String choice = promptString(mainRoom); // Call prompt method
            try {
                int door = Integer.parseInt(choice);

                switch (door) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        keyAndRoomsText(rooms, seenRooms, keys, door - 1);
                        break;

                    case 5:
                        boolean unlock = true;
                        for (int i = 0; i < keys.length; i++) {
                            if (keys[i] == false) {
                                print(rooms[4]); // Call print method
                                unlock = false;
                                break;
                            }
                        }
                        if (unlock) {
                            print(seenRooms[4]); // Call print method
                            keepLooping = false;
                        }
                        break;

                    default:
                        // Call print method
                        print("\nYou seem distracted by the decor of each door; try choosing again.");
                    }
                } catch (NumberFormatException ex) {
                    print("Invalid option. Try again.");
            }
        }
        // Call print method
        print("\nCongrats, " + name + "! You can now exit! Thanks for playing the Five Doors!");
    }
}