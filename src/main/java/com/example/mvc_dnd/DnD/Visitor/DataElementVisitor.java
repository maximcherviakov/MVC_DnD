package com.example.mvc_dnd.DnD.Visitor;

import com.example.mvc_dnd.DnD.Character.Character;
import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Races.CharacterRace;

import java.util.TreeMap;

public class DataElementVisitor implements Visitor {
    @Override
    public TreeMap visit(Character character) {
        TreeMap treeMap = new TreeMap<>();
        treeMap.put("Name", character.getName());
        return treeMap;
    }

    @Override
    public TreeMap visit(Stats stats) {
        TreeMap treeMap = new TreeMap<>();
        treeMap.put("Stats", stats.getStats());
        return treeMap;
    }

    @Override
    public TreeMap<String, String> visit(CharacterRace race) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("Race", race.getName());
        return treeMap;
    }
}
