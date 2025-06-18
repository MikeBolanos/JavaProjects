package wiz.hogwarts.spells;

public class Protego implements Spell {

    public void cast() {
    System.out.println("You conjure a shimmering, translucent shield to protect you from other spells.");
    }

    public String getIncantation() {
        return "Protego";
    }
}
