package com.example.mvc_dnd.Controller;

import com.example.mvc_dnd.DnD.Character.CareTaker;
import com.example.mvc_dnd.DnD.Character.Character;
import com.example.mvc_dnd.DnD.Character.Stats;
import com.example.mvc_dnd.DnD.Visitor.Element;
import com.example.mvc_dnd.Model.CharacterModel;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> raceComboBox;
    @FXML
    private ComboBox<String> classComboBox;
    @FXML
    private TextField STRField;
    @FXML
    private TextField DEXField;
    @FXML
    private TextField CONField;
    @FXML
    private TextField INTField;
    @FXML
    private TextField WISField;
    @FXML
    private TextField CHAField;
    @FXML
    private ListView<String> charactersListView;
    @FXML
    private TextArea infoTextArea;
    @FXML
    private TextArea jsonTextArea;

    private static CharacterModel model = CharacterModel.getInstance();
    private static ObservableList<String> listItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        charactersListView.setItems(listItems);
    }

    @FXML
    protected void onGenerateAttribsButtonClick() {
        model.setStats(Stats.generate());
        STRField.setText(model.getStats().getStats().get(Stats.STRENGTH).toString());
        DEXField.setText(model.getStats().getStats().get(Stats.DEXTERITY).toString());
        CONField.setText(model.getStats().getStats().get(Stats.CONSTITUTION).toString());
        INTField.setText(model.getStats().getStats().get(Stats.INTELLECT).toString());
        WISField.setText(model.getStats().getStats().get(Stats.WISDOM).toString());
        CHAField.setText(model.getStats().getStats().get(Stats.CHARISMA).toString());
    }

    @FXML
    protected void onSaveButtonClick() {
        if (model.getStats() != null) {
            model.setCareTaker(new CareTaker());
            model.getCareTaker().add(Character.saveStateToMemento(model.getStats()));
        }
    }

    @FXML
    protected void onReturnButtonClick() {
        try {
            model.getStats().undoToLastState(model.getCareTaker().getLast());
            STRField.setText(model.getStats().getStats().get(Stats.STRENGTH).toString());
            DEXField.setText(model.getStats().getStats().get(Stats.DEXTERITY).toString());
            CONField.setText(model.getStats().getStats().get(Stats.CONSTITUTION).toString());
            INTField.setText(model.getStats().getStats().get(Stats.INTELLECT).toString());
            WISField.setText(model.getStats().getStats().get(Stats.WISDOM).toString());
            CHAField.setText(model.getStats().getStats().get(Stats.CHARISMA).toString());
        } catch (Exception exception) {
            infoTextArea.setText("No saved attributes found!");
        }
    }

    @FXML
    protected void onCreateCharacterButtonClick() {
        infoTextArea.clear();
        if (model.getStats() == null) {
            infoTextArea.setText("Generate attributes before creating character");
            return;
        }

        String name = nameField.getText();
        if (name.replace(" ", "").equals("")) {
            infoTextArea.setText("Name field is empty!");
            return;
        }

        String race = raceComboBox.getValue();
        if (race.replace(" ", "").equals("")) {
            infoTextArea.setText("Race field is empty!");
            return;
        }

        String characterClass = classComboBox.getValue();
        if (characterClass.replace(" ", "").equals("")) {
            infoTextArea.setText("Class field is empty!");
            return;
        }

        String listItemValue = race + "-" + characterClass + " " + name;
        if (model.addCharacter(listItemValue, name, race, characterClass) != null) {
            infoTextArea.setText("This name is already in use!\nChoose another");
            return;
        }

        listItems.add(listItemValue);
        infoTextArea.setText("Character " + name + " created");
    }

    @FXML
    protected void onSaveJsonButtonClick() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("characters.json");
        } catch (IOException e) {
            infoTextArea.clear();
            infoTextArea.setText("Have some troubles with saving characters to JSON!\nSorry)");
            return;
        }

        JSONArray jsonArray = model.getCharactersAsJson();
        jsonTextArea.setText(jsonArray.toJSONString());
        try {
            jsonArray.writeJSONString(writer);
        } catch (IOException e) {
            infoTextArea.setText("Have some troubles with saving characters to JSON!\nSorry)");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                infoTextArea.setText("Have some troubles with saving characters to JSON!\nSorry)");
            }
        }
    }

    @FXML
    protected void onCharactersListViewClick() {
        infoTextArea.clear();
        String selected = charactersListView.getSelectionModel().getSelectedItem();
        infoTextArea.setText(model.getCharacter(selected).toString());
    }
}