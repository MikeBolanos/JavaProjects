package wiz.hogwarts;

import wiz.hogwarts.spells.*;

import java.util.ArrayList;

public class SpellBook {
    private ArrayList<Spell> spells;

    public SpellBook() {
    spells = new ArrayList<>();
    spells.add(new Alohomora());
    spells.add(new Incendio());
    spells.add(new Protego());
    spells.add(new Stupefy());
    spells.add(new ExitSpell());

    }
public void tryIncantation(String incantation) {
        if (incantation.equalsIgnoreCase("help")) {
            help();
            return;
        }
        for (Spell spell : spells) {
            if (spell.getIncantation().equalsIgnoreCase(incantation)) {
               spell.cast();
               return;
            }
        }
        System.out.println("The spell fizzled out. Try again!");
    }

    public void help() {
        System.out.printf("%n%-15s %s%n", "Incantation", "Effect");
        for(Spell spell : spells) {
            System.out.println(spell.getHelp());
        }
    }


}
