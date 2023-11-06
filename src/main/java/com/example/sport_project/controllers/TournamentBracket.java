package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.Fight;
import com.example.sport_project.classes_for_controllers.Fighter;
import com.example.sport_project.classes_for_controllers.WeightCategory;
import com.example.sport_project.db_actions.sportsmenDb;
import com.example.sport_project.db_actions.*;
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
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                ArrayList<Fighter> sportsmens = sportsmenDb.getByWeight(weight);
                tournament_64Db.addDataLeft(sportsmens);
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                    Scene newscene = new Scene(loader.load());
                    Stage newstage = new Stage();
                    newstage.setScene(newscene);
                    newstage.setTitle("Турнирная сетка");
                    newstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                        @Override
                        public void handle(WindowEvent windowEvent) {
                            tournament_64Db.clearTable();
                            fight_32_leftDb.clearTable();
                            fight_32_rightDb.clearTable();
                            winner_32_leftDb.clearTable();
                            winner_32_rightDb.clearTable();
                            winner_64_leftDb.clearTable();
                            winner_64_rightDb.clearTable();
                            fight_16_leftDb.clearTable();
                            fight_16_rightDb.clearTable();

                            newstage.close();
                        }
                    });
                    newstage.showAndWait();

                    Stage btn_stage = (Stage) generate_btn.getScene().getWindow();
                    btn_stage.close();



                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}