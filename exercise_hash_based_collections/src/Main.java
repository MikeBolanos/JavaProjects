import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Create a HashMap with keys of the month numbers of the year and values of the String names
        HashMap<Integer, String> monthMap = new HashMap<>();
        monthMap.put(1, "January");
        monthMap.put(2, "February");
        monthMap.put(3, "March");
        monthMap.put(4, "April");
        monthMap.put(5, "May");
        monthMap.put(6, "June");
        monthMap.put(7, "July");
        monthMap.put(8, "August");
        monthMap.put(9, "September");
        monthMap.put(10, "October");
        monthMap.put(11, "November");
        monthMap.put(12, "December");

        // Use the keySet method in a for loop to print all the keys and their values to the console.
        for (Integer key : monthMap.keySet()) {
            System.out.println("Month #" + key + " is " + monthMap.get(key));
        }

        // Create a HashMap<String, List<String>> and load it with a card deck
        HashMap<String, List<String>> deck = new HashMap<>();
        // List of card ranks
        List<String> cards = new ArrayList<>();
        cards.add("Ace");
        cards.add("2");
        cards.add("3");
        cards.add("4");
        cards.add("5");
        cards.add("6");
        cards.add("7");
        cards.add("8");
        cards.add("9");
        cards.add("10");
        cards.add("Jack");
        cards.add("Queen");
        cards.add("King");

        // Put card list into lists of suits
        List<String> hearts = new ArrayList<>(cards);
        List<String> spades = new ArrayList<>(cards);
        List<String> diamonds = new ArrayList<>(cards);
        List<String> clubs = new ArrayList<>(cards);

        // Put suits into the deck HashMap
        deck.put("Hearts", hearts);
        deck.put("Spades", spades);
        deck.put("Diamonds", diamonds);
        deck.put("Clubs", clubs);

        // Print card deck formated as "[card rank] of [suit]"

    }
}
