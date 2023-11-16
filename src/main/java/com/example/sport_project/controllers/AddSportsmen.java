package com.example.sport_project.controllers;
import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.AgeCategory;
import com.example.sport_project.classes_for_controllers.SportClub;
import com.example.sport_project.classes_for_controllers.Sportsmen;
import com.example.sport_project.classes_for_controllers.WeightCategory;
import com.example.sport_project.db_actions.ageCategoryDb;
import com.example.sport_project.db_actions.sportClubDb;
import com.example.sport_project.db_actions.sportsmenDb;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AddSportsmen implements Initializable {
    @FXML
    Button confirm_btn;
    @FXML
    TextField name_field;

    @FXML
    private ToggleGroup action;

    @FXML
    private RadioButton action_yes;

    @FXML
    private RadioButton action_no;

    @FXML
    private ComboBox<String> age_choice;

    @FXML
    private DatePicker birthDate_choice;

    @FXML
    private TextField draw_field;

    @FXML
    private ComboBox<String> genderChoice;

    @FXML
    private ComboBox<String> sportClub_choice;

    @FXML
    private ComboBox<String> weight_choice;


    public void update_sportsmen(Sportsmen sportsmen){
        name_field.setText(sportsmen.getName());
        birthDate_choice.setValue(LocalDate.parse(sportsmen.getAge()));
        genderChoice.setValue(sportsmen.getGender());
        age_choice.setValue(sportsmen.getAge_category());
        weight_choice.setValue(sportsmen.getWeight());
        sportClub_choice.setValue(sportsmen.getSport_club());
        draw_field.setText(String.valueOf(sportsmen.getDraw_num()));
        if(sportsmen.getAct().equals("ДА")){
            action_yes.setSelected(true);
        }
        else if(sportsmen.getAct().equals("НЕТ")) {
            action_no.setSelected(true);
        }
        confirm_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    String sport_club = sportClub_choice.getValue();
                    LocalDate birthDate = birthDate_choice.getValue();
                    int draw_num = Integer.parseInt(draw_field.getText());
                    String name = name_field.getText();
                    String weight_cat = weight_choice.getValue();
                    String age_cat = age_choice.getValue();
                    String gender = genderChoice.getValue();
                    if(sportsmenDb.getNames().contains(sportsmen.getName())){
                        if(action_yes.isSelected()){
                            sportsmenDb.updateSportsmen(sportsmen.getName(), name, draw_num, birthDate.toString(), sport_club, gender, true, weight_cat, age_cat);
                        }
                        else if(action_no.isSelected()){
                            sportsmenDb.updateSportsmen(sportsmen.getName(), name, draw_num, birthDate.toString(), sport_club, gender, false, weight_cat, age_cat);
                        }
                    }
                    Stage stage = (Stage) confirm_btn.getScene().getWindow();
                    stage.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> genders = FXCollections.observableArrayList("Мужчина", "Женщина");
        genderChoice.setItems(genders);
        genderChoice.setValue("Мужчина");

        ObservableList<String> clubs = sportClubDb.getSportClub().stream()
                .map(SportClub::getName) // Здесь предполагается, что у SportClub есть метод getName() для получения имени клуба.
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        sportClub_choice.setItems(clubs);
        sportClub_choice.setValue(sportClubDb.getFirst());
        ObservableList<String> ages = ageCategoryDb.getAge().stream()
                .map(AgeCategory::getAge) // Здесь предполагается, что у SportClub есть метод getName() для получения имени клуба.
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        age_choice.setItems(ages);
        age_choice.setValue(ageCategoryDb.getFirst());


        ObservableList<String> weights = weightCategoryDb.getWeight().stream()
                .map(WeightCategory::getWeight) // Здесь предполагается, что у SportClub есть метод getName() для получения имени клуба.
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        weight_choice.setItems(weights);
        weight_choice.setValue(weightCategoryDb.getFirst());



        String name_first = name_field.getText();


        confirm_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {

                    boolean action_ = true;
                    if(action_no.isSelected()){
                        action_ = false;
                    }
                    String sport_club = sportClub_choice.getValue();
                    LocalDate birthDate = birthDate_choice.getValue();
                    int draw_num = Integer.parseInt(draw_field.getText());
                    String name = name_field.getText();
                    String weight_cat = weight_choice.getValue();
                    String age_cat = age_choice.getValue();
                    String gender = genderChoice.getValue();
                    sportsmenDb.write(name, draw_num, birthDate.toString(), sport_club, gender, action_, weight_cat, age_cat);
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/hello-view.fxml"));
                    Scene newscene = new Scene(loader.load());
                    Stage newstage = new Stage();
                    HelloController helloController = loader.getController();
                    helloController.updateData();
                    Stage stage = (Stage) confirm_btn.getScene().getWindow();
                    stage.close();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
