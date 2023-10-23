package com.example.sport_project.controllers;

import com.example.sport_project.classes_for_controllers.Tournament_64;
import com.example.sport_project.db_actions.tournament_64Db;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Bracket64 implements Initializable {
    @FXML
    private TableView<Tournament_64> left_64;
    @FXML
    private TableColumn<String, Tournament_64> name;
    @FXML
    private TableColumn<Integer, Tournament_64> fight_num;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        fight_num.setCellValueFactory(new PropertyValueFactory<>("fight_num"));
        left_64.setItems(tournament_64Db.getDataLeft());
    }
}
