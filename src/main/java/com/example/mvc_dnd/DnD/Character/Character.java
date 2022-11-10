package com.example.mvc_dnd.DnD.Character;

import com.example.mvc_dnd.DnD.Classes.CharacterClass;
import com.example.mvc_dnd.DnD.Visitor.Element;
import com.example.mvc_dnd.DnD.Visitor.Visitor;
import com.example.mvc_dnd.DnD.Races.CharacterRace;
import com.example.mvc_dnd.DnD.Races.RaceAbstractFactory;

import java.util.Set;
import java.util.TreeMap;

// Originator
public class Character implements Element {
    private String name;
    private Stats attributes;
    private CharacterRace race;
    private CharacterClass characterClass;

    public Character(String name) {
        this.name = name;
        this.attributes = Stats.generate();
    }

    public Character(String name, RaceAbstractFactory race, CharacterClass characterClass) {
        this.name = name;
        this.race = race.create();
        this.characterClass = characterClass;
        this.attributes = Stats.generate();
    }

    public Character(String name, RaceAbstractFactory race, CharacterClass characterClass, Stats stats) {
        this.name = name;
        this.race = race.create();
        this.characterClass = characterClass;
        this.attributes = stats;
    }

    public Character(String name, String dndclass, Stats attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public void addRaceBonuses() {
        Set<String> keys = attributes.getStats().keySet();

        for (String key : keys) {
            attributes.getStats().put(key, attributes.getStats().get(key) + race.getRaceBonuses().getStats().get(key));
        }
    }

    public String getName() {
        return name;
    }

    public Stats getAttributes() {
        return attributes;
    }

    public CharacterRace getRace() {
        return race;
    }

    public void talk() {
        race.saySomething();
    }

    public void printSheet() {
        System.out.println("Character" +
                "\nName: " + name);
        characterClass.print();
        race.print();
        attributes.print();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    public static Memento saveStateToMemento(Stats state) {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        this.attributes = memento.getState();
    }

    public void setAttributes(Stats attributes) {
        this.attributes = attributes;
    }

    @Override
    public TreeMap accept(Visitor visitor) {
        return visitor.visit(this);
    }

    // Memento
    public static class Memento {
        private final Stats state;

        private Memento(Stats state) {
            this.state = state;
        }

        public Stats getState() {
            return state;
        }
    }
}
