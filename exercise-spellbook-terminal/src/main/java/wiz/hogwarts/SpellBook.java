package wiz.hogwarts;

import wiz.hogwarts.spells.*;

import java.util.ArrayList;

public class SpellBook {
    private ArrayList<Spell> spells;

    public SpellBook() {
    spells = new ArrayList<>();
    spells.add(new ExitSpell());
    
    }
}
