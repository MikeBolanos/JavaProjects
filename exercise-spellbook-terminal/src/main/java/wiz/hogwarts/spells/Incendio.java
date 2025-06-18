package wiz.hogwarts.spells;

public class Incendio implements Spell {
    public void cast() {
        System.out.println("Flames erupt from the ground to ignite your target in a searing blaze!");
    }

    public String getIncantation() {
        return "Incendio";
    }

    public String getHelp() {
        return String.format("%-15s %s", getIncantation(), "Conjure wild flames at an area of your choosing.");
    }
}
