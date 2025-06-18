package wiz.hogwarts.spells;

public class Protego implements Spell {

    public void cast() {
    System.out.println("You conjure a shimmering, translucent shield to float a couple of feet in front of you.");
    }

    public String getIncantation() {
        return "Protego";
    }
}
