package com.example.oop2a3zms.Controllers;

import com.example.oop2a3zms.Model.Animal;
import com.example.oop2a3zms.Model.Lion;
import com.example.oop2a3zms.Model.Cougar;
import com.example.oop2a3zms.Model.Eagle;
import com.example.oop2a3zms.Model.Parrot;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controls the animal management view.
 *
 * @author Keren
 */
public class AnimalController {

    @FXML
    private Label aEnclosureNameLabel;

    @FXML
    private ListView<Animal> aAnimalListView;

    @FXML
    private ComboBox<String> aAnimalTypeComboBox;

    @FXML
    private TextField aNameTextField;

    @FXML
    private TextField aAgeTextField;

    /**
     * Initializes the animal type dropdown.
     */
    @FXML
    public void initialize() {
        aAnimalTypeComboBox.getItems().addAll(
                "Lion", "Cougar", "Eagle",
                "Parrot", "Penguin", "Tiger"
        );
    }

    /**
     * Adds a new animal to the list.
     */
    @FXML
    private void onAddAnimalClick() {

        String name = aNameTextField.getText().trim();
        String ageText = aAgeTextField.getText().trim();
        String type = aAnimalTypeComboBox.getValue();

        // Checks that all fields have been completed.
        if (name.isEmpty() || ageText.isEmpty() || type == null) {
            showMessage("Please enter a name, age and animal type.");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);

            // Checks that the age is not negative.
            if (age < 0) {
                showMessage("Age cannot be negative.");
                return;
            }

            // Creates the selected type of animal.
            Animal animal = createAnimal(type, name, age);

            if (animal != null) {
                aAnimalListView.getItems().add(animal);
                clearFields();
            }

        } catch (NumberFormatException e) {
            showMessage("Please enter a valid number for the age.");
        }
    }

    /**
     * Creates an animal based on the selected type.
     *
     * @param type the selected animal type
     * @param name the animal's name
     * @param age the animal's age
     * @return the created animal
     */
    private Animal createAnimal(String type, String name, int age) {

        if (type.equals("Lion")) {
            return new Lion(name, age);
        } else if (type.equals("Cougar")) {
            return new Cougar(name, age);
        } else if (type.equals("Eagle")) {
            return new Eagle(name, age);
        } else if (type.equals("Parrot")) {
            return new Parrot(name, age);
        }

        return null;
    }

    /**
     * Updates the selected animal's information.
     */
    @FXML
    private void onUpdateAnimalClick() {

        Animal selectedAnimal =
                aAnimalListView.getSelectionModel().getSelectedItem();

        // Checks that an animal has been selected.
        if (selectedAnimal == null) {
            showMessage("Please select an animal to update.");
            return;
        }

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

            // Updates the selected animal.
            selectedAnimal.setName(name);
            selectedAnimal.setAge(age);

            aAnimalListView.refresh();
            clearFields();

        } catch (NumberFormatException e) {
            showMessage("Please enter a valid number for the age.");
        }
    }

    /**
     * Removes the selected animal from the list.
     */
    @FXML
    private void onRemoveAnimalClick() {

        Animal selectedAnimal =
                aAnimalListView.getSelectionModel().getSelectedItem();

        // Checks that an animal has been selected.
        if (selectedAnimal == null) {
            showMessage("Please select an animal to remove.");
            return;
        }

        aAnimalListView.getItems().remove(selectedAnimal);
        clearFields();
    }

    /**
     * Closes the animal management window.
     */
    @FXML
    private void onBackClick() {
        Stage stage = (Stage) aNameTextField.getScene().getWindow();
        stage.close();
    }

    /**
     * Clears the input fields.
     */
    private void clearFields() {
        aNameTextField.clear();
        aAgeTextField.clear();
        aAnimalTypeComboBox.setValue(null);
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
}
