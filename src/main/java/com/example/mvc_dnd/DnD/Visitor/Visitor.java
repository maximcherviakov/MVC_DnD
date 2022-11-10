package com.example.mvc_dnd.DnD.Visitor;

import com.example.mvc_dnd.DnD.Character.Character;
import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Races.CharacterRace;

import java.util.TreeMap;

public interface Visitor {
    TreeMap visit(Character visitor);

    TreeMap visit(Stats stats);

    TreeMap visit(CharacterRace race);
}
