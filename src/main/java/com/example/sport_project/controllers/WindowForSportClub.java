package com.example.sport_project.controllers;


import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.SportClub;
import com.example.sport_project.classes_for_controllers.Sportsmen;
import com.example.sport_project.db_actions.sportClubDb;
import com.example.sport_project.db_actions.sportsmenDb;
import javafx.application.Platform;
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
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowForSportClub implements Initializable {

    @FXML
    private MenuItem data_delete;

    @FXML
    private MenuItem add_sport_club_btn;

    @FXML
    private TableView<SportClub> sport_club_table;

    @FXML
    private TableColumn<SportClub, Integer> id_col;

    @FXML
    private TableColumn<SportClub, String> name_col;

    @FXML
    private MenuItem update_table;



    public void updateData(){
        sport_club_table.getItems().clear();
        sport_club_table.setItems(sportClubDb.getSportClub());
        sport_club_table.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        update_table.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateData();
            }
        });


        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        updateData();

        TableView.TableViewSelectionModel<SportClub> selectionModel = sport_club_table.getSelectionModel();


        data_delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!selectionModel.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Успешно");
                    alert.setHeaderText(null);
                    alert.setContentText("Спортклуб "+ selectionModel.getSelectedItem().getName() + " успешно удалён!");
                    alert.showAndWait();
                    sportClubDb.deleteSportClub(selectionModel.getSelectedItem().getName());
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



        add_sport_club_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/add_sportClub.fxml"));
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
    }


}