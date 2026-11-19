package com.example.oop2a3zms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZMSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZMSApplication.class.getResource("zooSection-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 530);
        stage.setTitle("Zoo Management System");
        stage.setScene(scene);
        stage.show();
    }
}
    
