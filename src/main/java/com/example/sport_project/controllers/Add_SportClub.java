package com.example.sport_project.controllers;

import com.example.sport_project.classes_for_controllers.SportClub;
import com.example.sport_project.classes_for_controllers.WeightCategory;
import com.example.sport_project.db_actions.sportClubDb;
import com.example.sport_project.db_actions.weightCategoryDb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Add_SportClub implements Initializable {

    @FXML
    private TextField addSportClub;
    @FXML
    private Button add_sport_club_btn;

    public void update_SportClub(SportClub sportClub){
        addSportClub.setText(sportClub.getName());
        add_sport_club_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sportClubDb.update_SportClub(sportClub.getName(), addSportClub.getText());
                Stage stage =  (Stage) add_sport_club_btn.getScene().getWindow();
                stage.close();

            }
        });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {




        add_sport_club_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String sport_club = addSportClub.getText();
                sportClubDb.addSportCLub(sport_club);
                Stage stage = (Stage) add_sport_club_btn.getScene().getWindow();
                stage.close();
            }
        });


    }
}

