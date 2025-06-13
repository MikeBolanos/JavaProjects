public class Character {

    // Fields
    private String name;
    private int health;
    private int attackPower;

    // Constructor
    public Character( String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Method for attack action
    public void attack() {
        System.out.println("\nThe character performs an attack!");
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
