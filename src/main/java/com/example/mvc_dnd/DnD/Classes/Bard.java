package com.example.mvc_dnd.DnD.Classes;

import java.util.LinkedList;
import java.util.List;

public class Bard extends CharacterClass {
    private List<String> spells;

    public Bard() {
        name = "Bard";
        hp = 8;

        spells = new LinkedList<>();
        spells.add("Charm Person");
        spells.add("Heroism");
    }

    @Override
    public void printMagika() {
        System.out.println("Class " + name + ", knows spells:");
        for (String spell : spells) {
            System.out.println("\t" + spell);
        }
    }
}
