public class Archer extends Character {
    private final String bowType;

    public Archer(String name, int health, int attackPower, String bowType) {
        super(name, health, attackPower);
        this.bowType = bowType;
    }
    // Override attack method to fit with Mage class
    @Override
    public void attack() {
        System.out.printf("The Mage attacks with %s!", bowType);
    }

    public String getBowType() {
        return bowType;
    }
}
