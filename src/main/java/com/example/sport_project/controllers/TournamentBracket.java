package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.WeightCategory;
import com.example.sport_project.db_actions.sportsmenDb;
import com.example.sport_project.db_actions.tournament_64Db;
import com.example.sport_project.db_actions.weightCategoryDb;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TournamentBracket implements Initializable {

    @FXML
    private ComboBox<String> weight_info;

    @FXML
    private Button generate_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> weights = weightCategoryDb.getWeight().stream()
                .map(WeightCategory::getWeight) // Здесь предполагается, что у SportClub есть метод getName() для получения имени клуба.
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        weight_info.setItems(weights);
        weight_info.setValue(weightCategoryDb.getFirst());



        generate_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String weight = weight_info.getValue();
                tournament_64Db.addDataLeft(sportsmenDb.getByWeight(weight));
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                    Scene newscene = new Scene(loader.load());
                    Stage newstage = new Stage();
                    newstage.setScene(newscene);
                    newstage.setTitle("Турнирная сетка");
                    newstage.showAndWait();

                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

    }
}