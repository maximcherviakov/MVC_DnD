package com.example.mvc_dnd;

import com.example.mvc_dnd.DnD.Classes.ClassFactory;
import com.example.mvc_dnd.DnD.Character.Character;
import com.example.mvc_dnd.DnD.Races.Dwarf.DwarfFactory;

public class Test {
    public static void main(String[] args) {
        Character character1 = new Character("Viarmo", new DwarfFactory(), ClassFactory.getClass("Bard"));
        character1.printSheet();
    }
}
