package com.example.mvc_dnd.DnD.Classes;

public class Barbarian extends CharacterClass {
    private String perk;

    public Barbarian() {
        name = "Barbarian";
        hp = 12;
        perk = "Battle Rage";
    }

    @Override
    public void printMagika() {
        System.out.println("Class " + name + ", can " + perk);
    }
}
