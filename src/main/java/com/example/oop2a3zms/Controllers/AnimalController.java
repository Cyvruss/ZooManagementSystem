package com.example.oop2a3zms.Controllers;

import com.example.oop2a3zms.Model.Animal;

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

    /**
     * Receives the animal selected from the enclosure view.
     *
     * @param pAnimal the selected animal
     */
    public void setAnimal(Animal pAnimal) {
        aAnimal = pAnimal;

        aNameTextField.setText(aAnimal.getName());
        aAgeTextField.setText(String.valueOf(aAnimal.getAge()));
    }

    /**
     * Saves the animal's information.
     */
    @FXML
    private void onSaveClick() {

        String name = aNameTextField.getText().trim();
        String ageText = aAgeTextField.getText().trim();

        // Checks that both fields are completed.
        if (name.isEmpty() || ageText.isEmpty()) {
            showMessage("Please enter a name and age.");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);

            // Checks that the age is not negative.
            if (age < 0) {
                showMessage("Age cannot be negative.");
                return;
            }

            // Updates the animal information.
            aAnimal.setName(name);
            aAnimal.setAge(age);

            closeWindow();

        } catch (NumberFormatException e) {
            showMessage("Please enter a valid whole number for the age.");
        }
    }

    /**
     * Closes the window without saving changes.
     */
    @FXML
    private void onCancelClick() {
        closeWindow();
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to display
     */
    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Animal Management");
        alert.setHeaderText(null);
        alert.setContentText(message);
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
