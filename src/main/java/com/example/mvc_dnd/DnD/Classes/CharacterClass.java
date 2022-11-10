package com.example.mvc_dnd.DnD.Classes;

public abstract class CharacterClass {
    protected String name;
    protected int hp;

    protected abstract void printMagika();

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Race: " + name);
        System.out.println("HP: " + hp);
        printMagika();
    }
}
