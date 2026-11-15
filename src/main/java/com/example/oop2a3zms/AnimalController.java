package com.example.oop2a3zms;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AnimalController {

    @FXML
    private Label aEnclosureNameLabel;

    @FXML
    private ListView aAnimalListView;

    @FXML
    private ComboBox aAnimalTypeComboBox;

    @FXML
    private TextField aNameTextField;

    @FXML
    private TextField aAgeTextField;

    @FXML
    public void initialize() {
        aAnimalTypeComboBox.getItems().addAll(
                "Lion", "Cougar", "Eagle", "Parrot", "Penguin", "Tiger"
        );
    }

    @FXML
    private void onAddAnimalClick() {
        System.out.println("Add button clicked");
    }

    @FXML
    private void onUpdateAnimalClick() {
        System.out.println("Update button clicked");
    }

    @FXML
    private void onRemoveAnimalClick() {
        System.out.println("Remove button clicked");
    }

    @FXML
    private void onBackClick() {
        Stage stage = (Stage) aNameTextField.getScene().getWindow();
        stage.close();
    }
}

