package com.example.mvc_dnd.Model;

import com.example.mvc_dnd.DnD.Character.CareTaker;
import com.example.mvc_dnd.DnD.Character.Character;
import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Classes.ClassFactory;
import com.example.mvc_dnd.DnD.Races.Dwarf.DwarfFactory;
import com.example.mvc_dnd.DnD.Races.Human.HumanFactory;
import com.example.mvc_dnd.DnD.Races.RaceAbstractFactory;
import com.example.mvc_dnd.DnD.Visitor.DataElementVisitor;
import com.example.mvc_dnd.DnD.Visitor.Element;
import com.example.mvc_dnd.DnD.Visitor.Visitor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CharacterModel {
    private static CharacterModel instance;
    private static HashMap<String, Character> characters = new HashMap<>();
    private Stats stats;
    private CareTaker careTaker;

    private CharacterModel() {

    }

    public static CharacterModel getInstance() {
        if (instance == null) {
            instance = new CharacterModel();
        }

        return instance;
    }

    public Character getCharacter(String label) {
        return characters.get(label);
    }

    public Character addCharacter(String lable, String name, String race, String characterClass) {
        RaceAbstractFactory raceAbstractFactory = null;

        if (race.equals("Dwarf")) {
            raceAbstractFactory = new DwarfFactory();
        } else if (race.equals("Human")) {
            raceAbstractFactory = new HumanFactory();
        }

        Character character = new Character(name, raceAbstractFactory, ClassFactory.getClass(characterClass), stats);
        return characters.put(lable, character);
    }

    public JSONArray getCharactersAsJson() {
        JSONArray jsonArray = new JSONArray();

        for (Character character : characters.values()) {
            JSONObject jsonObject = new JSONObject();
            Visitor visitor = new DataElementVisitor();
            List<Element> list = new LinkedList<>();
            list.add(character);
            list.add(character.getRace());
            list.add(character.getAttributes());

            for (Element element : list) {
                jsonObject.putAll(element.accept(visitor));
            }

            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public CareTaker getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(CareTaker careTaker) {
        this.careTaker = careTaker;
    }
}
