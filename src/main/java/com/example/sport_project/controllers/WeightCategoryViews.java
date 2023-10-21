package com.example.sport_project.controllers;

import com.example.sport_project.classes_for_controllers.WeightCategory;
import com.example.sport_project.db_actions.ageCategoryDb;
import com.example.sport_project.db_actions.weightCategoryDb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WeightCategoryViews implements Initializable {

    @FXML
    private Button add_weight_btn;

    @FXML
    private TextField addWeight;

    public void update_data(WeightCategory weight){
        addWeight.setText(weight.getWeight());
        add_weight_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                weightCategoryDb.update_weight(weight.getWeight(), addWeight.getText());
                Stage stage =  (Stage) add_weight_btn.getScene().getWindow();
                stage.close();

            }
        });

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        add_weight_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String weight = addWeight.getText();
                weightCategoryDb.addWeight(weight);
                Stage stage = (Stage) add_weight_btn.getScene().getWindow();
                stage.close();
            }
        });
    }

}