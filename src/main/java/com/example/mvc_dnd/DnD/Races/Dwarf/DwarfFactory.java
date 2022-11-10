package com.example.mvc_dnd.DnD.Races.Dwarf;

import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Races.CharacterRace;
import com.example.mvc_dnd.DnD.Races.RaceAbstractFactory;

public class DwarfFactory implements RaceAbstractFactory {
    @Override
    public CharacterRace create() {
        return new Dwarf("Dwarf", new Stats(0, 0, 2, 0, 1, 0));
    }
}
