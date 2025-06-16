import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        System.out.println();

        // Create a HashMap<String, List<String>> and load it with a card deck
        HashMap<String, List<String>> deck = new HashMap<>();
        // List of card ranks
        List<String> cardRank = new ArrayList<>();
        cardRank.add("Ace");
        cardRank.add("2");
        cardRank.add("3");
        cardRank.add("4");
        cardRank.add("5");
        cardRank.add("6");
        cardRank.add("7");
        cardRank.add("8");
        cardRank.add("9");
        cardRank.add("10");
        cardRank.add("Jack");
        cardRank.add("Queen");
        cardRank.add("King");

        // Put card list into lists of suits
        List<String> hearts = new ArrayList<>(cardRank);
        List<String> spades = new ArrayList<>(cardRank);
        List<String> diamonds = new ArrayList<>(cardRank);
        List<String> clubs = new ArrayList<>(cardRank);

        // Put suits into the deck HashMap
        deck.put("Hearts", hearts);
        deck.put("Spades", spades);
        deck.put("Diamonds", diamonds);
        deck.put("Clubs", clubs);

        // Print card deck formated as "[card rank] of [suit]"
        for (String suit : deck.keySet()) {
            List<String> cards = deck.get(suit);
            for (String card : cards) {
                System.out.println(card + " of " + suit);
            }
        }
    }
}
