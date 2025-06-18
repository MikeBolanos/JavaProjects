package wiz.hogwarts.spells;

public class Stupefy implements Spell {
    public void cast() {
        System.out.println("Your target rigidly freezes mid-action, falling unconscious!");
    }

    public String getIncantation() {
        return "Stupefy";
    }

    public String getHelp() {
        return String.format("%-15s %s", getIncantation(), "Stuns a target, rendering them unconscious and frozen in place.");
    }
}
