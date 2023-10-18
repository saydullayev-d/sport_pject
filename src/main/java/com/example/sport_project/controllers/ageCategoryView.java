package com.example.sport_project.controllers;

import com.example.sport_project.db_actions.ageCategoryDb;
import com.example.sport_project.db_actions.sportClubDb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ageCategoryView implements Initializable {

    @FXML
    private Button add_age_btn;

    @FXML
    private TextField addAge;

    @Override
    public void initialize(URL location, ResourceBundle resources){
            add_age_btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String age = addAge.getText();
                    ageCategoryDb.addAge(age);
                    Stage stage = (Stage) add_age_btn.getScene().getWindow();
                    stage.close();
                }
            });
    }
}
