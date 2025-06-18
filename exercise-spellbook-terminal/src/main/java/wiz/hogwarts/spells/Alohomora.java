package wiz.hogwarts.spells;

public class Alohomora implements Spell {

    public void cast() {
        System.out.println("The lock snaps open instantly!");
    }

    public String getIncantation() {
        return "Alohomora";
    }

    public String gethelp() {
        return String.format("%-15s %-30s", getIncantation(), "Cast a hole to exit the application through.");
    }
}
