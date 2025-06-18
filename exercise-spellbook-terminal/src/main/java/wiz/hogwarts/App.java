package wiz.hogwarts;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpellBook spellbook = new SpellBook();

        do {
            System.out.println("Recite a spell: ");
            String incantation = scanner.nextLine();
            spellbook.tryIncantation(incantation);
        }
        while (true);

    }
}
