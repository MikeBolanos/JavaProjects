package wiz.hogwarts.spells;

public class Alohomora implements Spell {

    public void cast() {
        System.out.println("The lock snaps open instantly!");
    }

    public String getIncantation() {
        return "Alohomora";
    }

    public String getHelp() {
        return String.format("%-15s %s", getIncantation(), "Cast on a lock to unlock it.");
    }
}
