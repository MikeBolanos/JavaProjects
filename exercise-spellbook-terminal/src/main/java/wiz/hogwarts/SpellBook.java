package wiz.hogwarts;

import wiz.hogwarts.spells.*;

import java.util.ArrayList;

public class SpellBook {
    private ArrayList<Spell> spells;

    public SpellBook() {
    spells = new ArrayList<>();
    spells.add(new ExitSpell());

    }
public void tryIncantation(String incantation) {
        for (Spell spell : spells) {
            if (spell.getIncantation().equalsIgnoreCase(incantation)) {
               spell.cast();
               return;
            }
        }
        System.out.println("The spell fizzled out. Try again!");
}

}
