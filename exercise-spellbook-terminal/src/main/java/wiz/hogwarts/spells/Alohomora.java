package wiz.hogwarts.spells;

public class Alohomora implements Spell {

    public void cast() {
        System.out.println("The lock snaps open instantly!");
    }

    public String getIncantation() {
        return "Alohomora";
    }
}
