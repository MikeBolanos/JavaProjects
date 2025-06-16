import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Create a HashMap with keys of the month numbers of the year and values of the String names
        Map<Integer, String> monthMap = new HashMap<>();
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
        Map<String, List<String>> cardDeck = new HashMap<>();
        cardDeck.put("Hearts", new ArrayList<>()
    }
}
