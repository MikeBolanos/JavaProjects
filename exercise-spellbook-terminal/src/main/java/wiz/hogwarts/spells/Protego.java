package wiz.hogwarts.spells;

public class Protego implements Spell {

    public void cast() {
    System.out.println("A shimmering, translucent shield appears and floats a couple of feet in front of you.");
    }

    public String getIncantation() {
        return "Protego";
    }

    public String getHelp() {
        return String.format("%-15s %s", getIncantation(), "Conjure a shield of protection to float in the air directly in front of you.");
    }
}
