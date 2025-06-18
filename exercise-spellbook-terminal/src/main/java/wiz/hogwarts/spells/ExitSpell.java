package wiz.hogwarts.spells;

public class ExitSpell implements Spell {
    public void cast() {
        System.out.println("A portal opens beneath your feet. Goodbye, wizard!");
        System.exit(0);
    }

    public String getIncantation() {
        return "quit";
    }

    public String gethelp() {
        return String.format("%-15s %-30s", getIncantation(), "Cast a hole to exit the application through.");
    }
}
