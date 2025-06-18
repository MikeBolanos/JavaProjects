package wiz.hogwarts.spells;

public class Stupefy implements Spell {
    public void cast() {
        System.out.println("You stun your target, freezing them in their tracks and rendering them unconscious!");
    }

    public String getIncantation() {
        return "Stupefy";

    }
}
