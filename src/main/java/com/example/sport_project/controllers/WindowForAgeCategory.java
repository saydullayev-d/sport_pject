package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.AgeCategory;
import com.example.sport_project.classes_for_controllers.WeightCategory;
import com.example.sport_project.db_actions.ageCategoryDb;
import com.example.sport_project.db_actions.weightCategoryDb;
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

public class WindowForAgeCategory implements Initializable {

    @FXML
    private MenuItem data_change;


    @FXML
    private MenuItem data_delete;

    @FXML
    private MenuItem update_table;

    @FXML
    private TableView<AgeCategory> age_table;

    @FXML
    private TableColumn<AgeCategory, Integer> id_col;

    @FXML
    private TableColumn<AgeCategory, String> age_col;

    @FXML

    private MenuItem add_age_category_btn;

    public void updateData(){
        age_table.getItems().clear();
        age_table.setItems(ageCategoryDb.getAge());
        age_table.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        age_col.setCellValueFactory(new PropertyValueFactory<>("age"));
        updateData();

        update_table.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateData();
            }
        });


        TableView.TableViewSelectionModel<AgeCategory> selectionModel = age_table.getSelectionModel();
        data_delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!selectionModel.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Успешно");
                    alert.setHeaderText(null);
                    alert.setContentText("Возрастная категория "+ selectionModel.getSelectedItem().getAge() + " успешно удалена!");
                    alert.showAndWait();
                    ageCategoryDb.deleteAgeCategory(selectionModel.getSelectedItem().getAge());
                    updateData();


                } else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Уведомление");
                    alert.setHeaderText(null);
                    alert.setContentText("Вы не выбрали ни одну возрастную категорию!\nВыберете возрастную категорию нажав в таблице.");
                    alert.showAndWait();
                }

            }
        });

        data_change.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/ageCategoryView.fxml"));
                    Scene newscene = new Scene(loader.load());
                    Stage newstage = new Stage();
                    ageCategoryView addAge_controller = loader.getController();
                    if(!selectionModel.isEmpty()){
                        addAge_controller.update_SportClub(selectionModel.getSelectedItem());
                        newstage.setScene(newscene);
                        newstage.setTitle("Добавить весовую категорию");
                        newstage.showAndWait();}
                    else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Уведомление");
                        alert.setHeaderText(null);
                        alert.setContentText("Вы не выбрали ни одну весовую категорию!\nВыберете весовую категорию нажав в таблице.");
                        alert.showAndWait();
                    }


                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        add_age_category_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/ageCategoryView.fxml"));
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

    }
}