package wiz.hogwarts.spells;

public class ExitSpell implements Spell {
    public void cast() {
        System.out.println("A portal opens beneath your feet. Goodbye, wizard!");
        System.exit(0);
    }

    public String getIncantation() {
        return "quit";
    }

    public String getHelp() {
        return String.format("%-15s %s", getIncantation(), "Cast a hole through which you can exit the application.");
    }
}
