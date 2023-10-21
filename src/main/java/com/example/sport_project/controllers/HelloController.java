package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.Sportsmen;
import com.example.sport_project.db_actions.sportsmenDb;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class HelloController implements Initializable {

    @FXML
    private MenuItem tournament_bracket;

    @FXML
    private MenuItem addSportClub;
    @FXML
    private MenuItem data_change;
    @FXML
    private MenuItem add_file_btn;
    @FXML
    private MenuItem data_delete;
    @FXML
    private MenuItem weightCategory;

    @FXML
    private MenuItem addSportsmen;
    @FXML
    private  MenuItem ageCategory;

    @FXML
    private TableView<Sportsmen> sportTable;

    @FXML
    private TableColumn<Sportsmen, String> age_col;

    @FXML
    private TableColumn<Sportsmen, Boolean> act_col;

    @FXML
    private TableColumn<Sportsmen, String> club_col;

    @FXML
    private TableColumn<Sportsmen, String> date_col;

    @FXML
    private TableColumn<Sportsmen, String> draw_col;

    @FXML
    private TableColumn<Sportsmen, String> gender_col;

    @FXML
    private TableColumn<Sportsmen, String> name_col;

    @FXML
    private TableColumn<Sportsmen, Integer> reg_col;

    @FXML
    private TableColumn<Sportsmen, String> weight_col;




    public void updateData(){
            sportTable.getItems().clear();
            sportTable.setItems(sportsmenDb.getData());
            sportTable.refresh();
    }








    @Override
    public void initialize(URL location, ResourceBundle resources) {

        weight_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("weight"));
        reg_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, Integer>("reg_num"));
        age_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("age_category"));
        name_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("name"));
        gender_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("gender"));
        draw_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("draw_num"));
        date_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("age"));
        club_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("sport_club"));
        act_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, Boolean>("act"));

        updateData();



        TableView.TableViewSelectionModel<Sportsmen> selectionModel = sportTable.getSelectionModel();

        data_change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/add_sportsmen.fxml"));
                    Scene newscene = new Scene(loader.load());
                    Stage newstage = new Stage();
                    AddSportsmen addSportsmen_controller = loader.getController();
                    if(!selectionModel.isEmpty()){
                        addSportsmen_controller.update_sportsmen(selectionModel.getSelectedItem());
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить спортсмена");
                        newstage.showAndWait();}
                    else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Уведомление");
                        alert.setHeaderText(null);
                        alert.setContentText("Вы не выбрали ни одного спорстмена!\nВыберете спорсмена нажав в таблице.");
                        alert.showAndWait();
                    }


                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        data_delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!selectionModel.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Успешно");
                    alert.setHeaderText(null);
                    alert.setContentText("Спорстмен "+ selectionModel.getSelectedItem().getName() + " успешно удалён!");
                    alert.showAndWait();
                    sportsmenDb.deleteSportsmen(selectionModel.getSelectedItem().getName());
                    updateData();


                } else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Уведомление");
                    alert.setHeaderText(null);
                    alert.setContentText("Вы не выбрали ни одного спорстмена!\nВыберете спорсмена нажав в таблице.");
                    alert.showAndWait();
                }

            }
        });

        addSportsmen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/add_sportsmen.fxml"));
                        Scene newscene = new Scene(loader.load());
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить спортсмена");
                        newstage.showAndWait();

                    }catch (Exception e){
                        System.out.println(e);
                    }
            }
        });
        ageCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/window_for_age_category.fxml"));
                        Scene newscene = new Scene(loader.load());
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить возрастную категорию");
                        newstage.showAndWait();

                    }catch (Exception e){
                        System.out.println(e);
                    }
                });
            }
        });


        addSportClub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/window_for_sport_club.fxml"));
                        Scene newscene = new Scene(loader.load());
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить спортивный клуб");
                        newstage.showAndWait();

                    }catch (Exception e){
                        System.out.println(e);
                    }
                });
            }
        });

        weightCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/window_for_weight_category.fxml"));
                        Scene newscene = new Scene(loader.load());
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить весовую категорию");
                        newstage.showAndWait();

                    }catch (Exception e){
                        System.out.println(e);
                    }
                });
            }
        });

        add_file_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Выберите Excel файл");
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(extFilter);
                File selectedFile = fileChooser.showOpenDialog(new Stage());
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/file.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    fileController fileController = loader.getController();
                    fileController.insertData(selectedFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        tournament_bracket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/tournament_bracket.fxml"));
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