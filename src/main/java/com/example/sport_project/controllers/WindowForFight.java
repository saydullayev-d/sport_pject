package com.example.sport_project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class WindowForFight {

    @FXML
    private Button win_1_btn;

    @FXML
    private Button win_2_btn;

    @FXML
    private Text win_sportsmen_2;

    @FXML
    private Text win_sportsmen_1;


    public void name_winner(String Sportsmen1, String Sportsmen2){
        win_sportsmen_1.setText(Sportsmen1);
        win_sportsmen_2.setText(Sportsmen2);





    }

}