package com.example.mvc_dnd.DnD.Character;

import com.example.mvc_dnd.DnD.Visitor.Element;
import com.example.mvc_dnd.DnD.Visitor.Visitor;

import java.util.HashMap;
import java.util.TreeMap;

public class Stats implements Element {
    public static final String STRENGTH = "Strength";
    public static final String DEXTERITY = "Dexterity";
    public static final String CONSTITUTION = "Constitution";
    public static final String INTELLECT = "Intellect";
    public static final String WISDOM = "Wisdom";
    public static final String CHARISMA = "Charisma";

    HashMap<String, Integer> stats;

    public Stats(int strength, int dexterity, int constitution, int intellect, int wisdom, int charisma) {
        stats = new HashMap<>();

        stats.put("Strength", strength);
        stats.put("Dexterity", dexterity);
        stats.put("Constitution", constitution);
        stats.put("Intellect", intellect);
        stats.put("Wisdom", wisdom);
        stats.put("Charisma", charisma);
    }

    public static Stats generate() {
        return new Stats(Dice.rollStat(), Dice.rollStat(), Dice.rollStat(), Dice.rollStat(), Dice.rollStat(), Dice.rollStat());
    }

    public void undoToLastState(Character.Memento memento) {
        this.stats = memento.getState().getStats();
    }

    public void print() {
        System.out.println("~~~~Attributes~~~~");
        System.out.println(this);
    }

    public HashMap<String, Integer> getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return "\n\tStrength: " + stats.get("Strength") +
               "\n\tDexterity: " + stats.get("Dexterity") +
               "\n\tConstitution: " + stats.get("Constitution") +
               "\n\tIntellect: " + stats.get("Intellect") +
               "\n\tWisdom: " + stats.get("Wisdom") +
               "\n\tCharisma: " + stats.get("Charisma") + "\n";
    }

    @Override
    public TreeMap accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
