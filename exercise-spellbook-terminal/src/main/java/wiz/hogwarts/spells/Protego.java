package wiz.hogwarts.spells;

public class Protego implements Spell {

    public void cast() {
    System.out.println("You conjure a shimmering, translucent shield to float a couple of feet in front of you.");
    }

    public String getIncantation() {
        return "Protego";
    }

    public String gethelp() {
        return String.format("%-15s %-30s", getIncantation(), "Cast a hole to exit the application through.");
    }
}
