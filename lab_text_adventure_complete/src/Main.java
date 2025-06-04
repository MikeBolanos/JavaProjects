import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner adventure = new Scanner(System.in);

        System.out.println("Welcome to the Five Doors!");
        boolean keepLooping = true;
        String[] rooms = new String[5];
        String[] seenRooms = new String[5];

        boolean[] keys = new boolean[4];

        String mainRoom = """
                
                You are in a large room with three doors:\
                
                1. The full brass door\
                
                2. The shiny steel door\
                
                3. The golden door\
                
                4. The copper door\
                
                5. The silver door\
                
                Which door do you choose to enter? (1, 2, 3, 4, 5):\s""";

        rooms [0] = "\nYou push the brass door open, revealing a small aquatic-themed library. On a side table, you see a book with a brass key being used as a bookmark. You take the key";
        rooms [1] = "\nYou use all your might to push open the shiny steel door. You see a room full of medieval weapons displayed on the walls and in cases and racks. You find a steel key hanging on one of the weapon racks!";
        rooms [2] = "\nThe silver door slides to the side, into the wall, and you find a large taxidermy werewolf! Around its neck is a silver key on a cord. You carefully claim the key.";
        rooms [3] = "\nYou push open the copper door and reveal a room full of piles copper currencies old and new. You search a few piles and finally find a copper key!";
        rooms [4] = "\n You attempt to open the golden door, but it won't open. You notice four keyholes the other doors do not have...";

        seenRooms[0] = "\nYou go through the brass door again. You find nothing else in the library.";
        seenRooms[1] = "\nYou go through the steel door again. You admire the many weapons, but there aren't any more keys.";
        seenRooms[2] = "\nYou go through the silver door again. Did the stuffed werewolf move? No... of course not. You leave quickly.";
        seenRooms[3] = "\nYou go through the copper door again. Somehow the piles are now in ordered stacks. Nothing else is new.";
        seenRooms[4] = "\nYou insert all four keys and unlock the golden door. When you open it, you find... the exit!";
        while (keepLooping) {
            System.out.print(mainRoom);
            String choice = adventure.nextLine();
            int door = Integer.parseInt(choice);
            switch (door) {
                case 1:
                case 2:
                case 3:
                case 4:
                    if (keys[door - 1]) {
                        System.out.println(seenRooms[door - 1]);
                    } else {
                        keys[door - 1] = true;
                        System.out.println(rooms[door -1]);
                    }
                    break;

                case 5:
                    boolean unlock = true;
                for (int i = 0; i < keys.length; i++) {
                    if (keys[i] == false) {
                        System.out.println(rooms[5]);
                        unlock = false;
                        break;
                    }
                }
                if (unlock) {
                    System.out.println(rooms[5]);
                    keepLooping = false;
                }
                break;

                default:
                    System.out.println("\nYou seem distracted by the decor of each door; try choosing again.");
            }
        }
        System.out.println("\nThanks for playing the Five Doors!");
    }
}
