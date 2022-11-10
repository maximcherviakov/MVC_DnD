package com.example.mvc_dnd.DnD.Races.Human;

import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Races.CharacterRace;

public class Human extends CharacterRace {
    public Human(String name, Stats bonuses) {
        this.name = name;
        this.bonuses = bonuses;
    }

    @Override
    public void saySomething() {
        System.out.println("I am Human");
    }
}
