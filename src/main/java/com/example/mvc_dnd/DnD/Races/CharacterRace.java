package com.example.mvc_dnd.DnD.Races;

import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Visitor.Element;
import com.example.mvc_dnd.DnD.Visitor.Visitor;

import java.util.TreeMap;

public abstract class CharacterRace implements Element {
    protected String name;
    protected Stats bonuses;

    public abstract void saySomething();

    public Stats getRaceBonuses() {
        return bonuses;
    }

    public void print() {
        System.out.println("Race: " + name);
        System.out.println("Bonuses:");
        System.out.println(bonuses.toString());
    }

    public String getName() {
        return name;
    }

    @Override
    public TreeMap accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
