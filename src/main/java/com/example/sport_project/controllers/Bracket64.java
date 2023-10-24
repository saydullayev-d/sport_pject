package com.example.sport_project.controllers;

import com.example.sport_project.db_actions.tournament_64Db;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Bracket64 implements Initializable {


    @FXML
    private Text _64_1;

    @FXML
    private Text _64_3;

    @FXML
    private Text _64_5;

    List<Text> textList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textList.add(_64_1);
        textList.add(_64_3);
        textList.add(_64_5);
        for(Text text: textList){
            String name = tournament_64Db.getDataLeft().get(textList.indexOf(text)).getName();
            String fight_num = tournament_64Db.getDataLeft().get(textList.indexOf(text)).getFight_num();
            System.out.print(name);
            System.out.print(" "+fight_num);
            System.out.println();
            if(text.getId().equals(fight_num)){
                text.setText(name);
            }
        }
        tournament_64Db.clearTable();
    }
}