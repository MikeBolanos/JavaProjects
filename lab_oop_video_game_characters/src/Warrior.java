public class Warrior extends Character {
    private String weaponType;

    public Warrior(String name, int health, int attackPower, String weaponType) {
        super(name, health, attackPower);
        this.weaponType = weaponType;
    }
    // Override attack method to fit with Warrior class
    @Override
    public void attack() {
        System.out.printf("The Warrior makes an attack with %s", weaponType);
    }


}
