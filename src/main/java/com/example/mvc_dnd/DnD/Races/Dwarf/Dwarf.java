package com.example.mvc_dnd.DnD.Races.Dwarf;

import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Races.CharacterRace;

public class Dwarf extends CharacterRace {
    public Dwarf(String name, Stats bonuses) {
        this.name = name;
        this.bonuses = bonuses;
    }

    @Override
    public void saySomething() {
        System.out.println("Tha yol Dwed");
    }
}
