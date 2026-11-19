 @FXML
    private Button addAnimalButton;

    @FXML
    private Button deleteButton;

    private Enclosure aCurrentEnclosure;

    // private void onEncEditAnimalButtonClick() {
    // we don't need this because onEditAnimalButtonClick() handles editing.

    @FXML
    private void onEncBackButtonClick() {
        Stage stage = (Stage) EncSectionTitleLabel.getScene().getWindow();
        stage.close();
    }

    // I replaced the old add method because it was not really creating a new animal.
    @FXML
    private void onAddAnimalButtonClick(ActionEvent pEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                ZMSApplication.class.getResource("animal-view.fxml")
        );

        Parent view = fxmlLoader.load();

        AnimalController aController = fxmlLoader.getController();
        aController.setEnclosure(aCurrentEnclosure);

        Scene nextScene = new Scene(view, 500, 500);

        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("Add Animal");

        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());

        nextStage.showAndWait();

        // Refreshes the list after adding an animal.
        updateView();
    }

    // Same here: this method opens the selected animal so its information can be edited.
    @FXML
    private void onEditAnimalButtonClick() throws IOException {

        ZooComponent aSelected =
                EncAnimalsListview.getSelectionModel().getSelectedItem();

        // Makes sure that the selected component is an animal.
        if (!(aSelected instanceof Animal)) {
            return;
        }

        Animal aSelectedAnimal = (Animal) aSelected;

        FXMLLoader aLoader = new FXMLLoader(
                ZMSApplication.class.getResource("animal-view.fxml")
        );

        Parent view = aLoader.load();

        AnimalController aController = aLoader.getController();
        aController.setAnimal(aSelectedAnimal);

        Stage aStage = new Stage();
        aStage.setScene(new Scene(view, 500, 500));
        aStage.setTitle("Edit Animal");

        aStage.initModality(Modality.WINDOW_MODAL);
        aStage.initOwner(EncAnimalsListview.getScene().getWindow());

        aStage.showAndWait();

        // Refreshes the list after editing an animal.
        updateView();
    }

    public void setEnclosure(Enclosure pEnclosure) {
        aCurrentEnclosure = pEnclosure;
        updateView();
    }

    private void updateView() {
        EncSectionTitleLabel.setText(aCurrentEnclosure.getName());

        EncAnimalsListview.getItems().setAll(
                aCurrentEnclosure.getComponents()
        );
    }
}
