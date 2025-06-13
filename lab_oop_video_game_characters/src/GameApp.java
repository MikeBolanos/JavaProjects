import java.util.ArrayList;
import java.util.List;

public class GameApp {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        characters.add(new Warrior("Conan", 98, 20, "greatsword"));
        characters.add(new Mage("Merlin", 70, 25, "lightning bolt" ));
        characters.add(new Archer("Robin", 63, 18, "longbow"));
    }
}
