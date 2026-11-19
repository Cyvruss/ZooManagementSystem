package com.example.oop2a3zms.Controllers;

import com.example.oop2a3zms.Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class ZooSectionController {

    @FXML
    private Label SectionNameLabel;

    @FXML
    private Label SectionAnimalCountLabel;

    @FXML
    private ListView<ZooComponent> SectionComponentsListView;

    private ZooSection aCurrentSection;

    public void setSection(ZooSection pSection) {
        aCurrentSection = pSection;
        updateView();
    }

    private void updateView() {
        SectionNameLabel.setText(aCurrentSection.getName());
        SectionAnimalCountLabel.setText("Total Animals: " + aCurrentSection.countAnimals());
        SectionComponentsListView.getItems().setAll(aCurrentSection.getComponents());
    }

    @FXML
    private void onSectionOpenButtonClick() throws IOException {
        ZooComponent aSelected = SectionComponentsListView.getSelectionModel().getSelectedItem();

        if (aSelected == null) {
            return;
        }

        FXMLLoader aLoader;

        if (aSelected instanceof ZooSection) {
            aLoader = new FXMLLoader(getClass().getResource("/com/example/oop2a3zms/ZooSectionView.fxml"));
        } else {
            aLoader = new FXMLLoader(getClass().getResource("/com/example/oop2a3zms/EnclosureView.fxml"));
        }

        Stage aStage = new Stage();
        aStage.setScene(new Scene(aLoader.load()));

        if (aSelected instanceof ZooSection) {
            aLoader.<ZooSectionController>getController().setSection((ZooSection) aSelected);
        } else {
            aLoader.<EnclosureController>getController().setEnclosure((Enclosure) aSelected);
        }

        aStage.showAndWait(); // changed the show for just the showandWait to make it wait until the other  is closed
    }

    @FXML
    private void onSectionBackButtonClick() {
        Stage aStage = (Stage) SectionNameLabel.getScene().getWindow();
        aStage.close();
    }
}