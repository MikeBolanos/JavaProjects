public class Mage extends Character  {
    private final String spell;

    public Mage(String name, int health, int attackPower, String spell) {
        super(name, health, attackPower);
        this.spell = spell;
    }
    // Override attack method to fit with Mage class
    @Override
    public void attack() {
        System.out.printf("The Mage attacks with %s!", spell);
    }

    public String getSpell() {
        return spell;
    }
}
