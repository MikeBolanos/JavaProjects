public class Warrior extends Character {
    private final String weaponType;

    public Warrior(String name, int health, int attackPower, String weaponType) {
        super(name, health, attackPower);
        this.weaponType = weaponType;
    }

    // Override attack method to fit with Warrior class
    @Override
    public void attack() {
        System.out.printf("\n" + getName() + " the Warrior charges and swings with a %s!\n", weaponType);
    }

    public String getWeaponType() {
        return weaponType;
    }
}
