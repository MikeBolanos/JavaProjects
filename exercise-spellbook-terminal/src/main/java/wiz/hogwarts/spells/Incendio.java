package wiz.hogwarts.spells;

public class Incendio implements Spell {
    public void cast() {
        System.out.println("You conjure fire to ignite your target in a searing blaze!");
    }

    public String getIncantation() {
        return "Incendio";
    }
}
