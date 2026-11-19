package com.example.oop2a3zms.Controllers;

import com.example.oop2a3zms.Model.Animal;
import com.example.oop2a3zms.Model.Enclosure;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controls the animal information view.
 *
 * @author Keren
 */
public class AnimalController {

    @FXML
    private TextField aNameTextField;

    @FXML
    private TextField aAgeTextField;

    private Animal aAnimal;
    private Enclosure aEnclosure;

    /**
     * Receives an existing animal when editing.
     *
     * @param pAnimal the selected animal
     */
    public void setAnimal(Animal pAnimal) {
        aAnimal = pAnimal;
        aEnclosure = null;

        aNameTextField.setText(aAnimal.getName());
        aAgeTextField.setText(String.valueOf(aAnimal.getAge()));
    }

    /**
     * Receives an enclosure when adding an animal.
     *
     * @param pEnclosure the current enclosure
     */
    public void setEnclosure(Enclosure pEnclosure) {
        aEnclosure = pEnclosure;
        aAnimal = null;

        aNameTextField.clear();
        aAgeTextField.clear();
    }

    /**
     * Saves the animal's information.
     */
    @FXML
    private void onSaveClick() {

        String name = aNameTextField.getText().trim();
        String ageText = aAgeTextField.getText().trim();

        if (name.isEmpty() || ageText.isEmpty()) {
            showMessage("Please enter a name and age.");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);

            if (age < 0) {
                showMessage("Age cannot be negative.");
                return;
            }

            if (aAnimal != null) {

                // Updates an existing animal.
                aAnimal.setName(name);
                aAnimal.setAge(age);

            } else if (aEnclosure != null) {

                // Creates and adds a new animal.
                Animal aNewAnimal = new Animal(name, age);
                aEnclosure.addComponent(aNewAnimal);

            } else {
                showMessage("Unable to save the animal.");
                return;
            }

            closeWindow();

        } catch (NumberFormatException e) {
            showMessage("Please enter a valid whole number for the age.");
        }
    }

    /**
     * Closes the window without saving.
     */
    @FXML
    private void onCancelClick() {
        closeWindow();
    }

    /**
     * Displays a message to the user.
     *
     * @param pMessage the message to display
     */
    private void showMessage(String pMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Animal Management");
        alert.setHeaderText(null);
        alert.setContentText(pMessage);
        alert.showAndWait();
    }

    /**
     * Closes the animal window.
     */
    private void closeWindow() {
        Stage stage = (Stage) aNameTextField.getScene().getWindow();
        stage.close();
    }
}
