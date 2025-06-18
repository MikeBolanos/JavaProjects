package wiz.hogwarts.spells;

public class Incendio implements Spell {
    public void cast() {
        System.out.println("You conjure fire to ignite your target in a searing blaze!");
    }

    public String getIncantation() {
        return "Incendio";
    }

    public String getHelp() {
        return String.format("%-15s %-30s", getIncantation(), "Cast a hole to exit the application through.");
    }
}
