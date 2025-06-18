package wiz.hogwarts.spells;

public class Stupefy implements Spell {
    public void cast() {
        System.out.println("You stun your target, freezing them in their tracks and rendering them unconscious!");
    }

    public String getIncantation() {
        return "Stupefy";
    }

    public String gethelp() {
        return String.format("%-15s %-30s", getIncantation(), "Cast a hole to exit the application through.");
    }
}
