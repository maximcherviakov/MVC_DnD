package com.example.mvc_dnd.DnD.Races.Human;

import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Races.CharacterRace;
import com.example.mvc_dnd.DnD.Races.RaceAbstractFactory;

public class HumanFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        return new Human("Human", new Stats(1, 1, 1, 1, 1, 1));
    }
}
