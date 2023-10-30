package com.example.sport_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image(HelloApplication.class.getResourceAsStream("icons/icon.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Спортсмены");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}