package com.example.mvc_dnd.DnD.Classes;

public class ClassFactory {
    public static CharacterClass getClass(String type) {
        if (type.equalsIgnoreCase("Bard")) {
            return new Bard();
        } else if (type.equalsIgnoreCase("Barbarian")) {
            return new Barbarian();
        }

        return null;
    }
}
