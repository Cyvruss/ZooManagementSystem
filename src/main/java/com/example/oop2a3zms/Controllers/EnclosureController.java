package com.example.oop2a3zms.Controllers;

import com.example.oop2a3zms.Model.Animal;
import com.example.oop2a3zms.Model.Enclosure;
import com.example.oop2a3zms.Model.ZooComponent;
import com.example.oop2a3zms.ZMSApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class EnclosureController {
    @FXML
    private Button EncEditAnimalButton;

    @FXML
    private Button EncBackButton;

    @FXML
    private Label EncSectionTitleLabel;

    @FXML
    private ListView<Animal> EncAnimalsListview;

    @FXML
    private Button addAnimalButton;

    @FXML
    private Button deleteButton;

    private Enclosure aCurrentEnclosure;

    @FXML
    private void onEncBackButtonClick() {
        Stage stage = (Stage) EncSectionTitleLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onAddAnimalButtonClick(Animal pAnimal, ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZMSApplication.class.getResource("animal-view.fxml"));
        Parent view = fxmlLoader.load();
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(pAnimal.getName());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }

    @FXML
    private void onEditAnimalButtonClick() throws IOException{
        Animal aSelected = EncAnimalsListview.getSelectionModel().getSelectedItem();
        if (aSelected == null) {
            return;
        }

        FXMLLoader aLoader = new FXMLLoader(getClass().getResource("/com/example/oop2a3zms/animal-view.fxml"));
        Stage aStage = new Stage();
        aStage.setScene(new Scene(aLoader.load()));

        aLoader.<AnimalController>getController().setAnimal(aSelected);
    }

    public void setEnclosure(Enclosure pEnclosure) {
        aCurrentEnclosure = pEnclosure;
        updateView();
    }

    private void updateView() {
        EncSectionTitleLabel.setText(aCurrentEnclosure.getName());
    }

}
