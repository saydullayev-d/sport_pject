package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.SportClub;
import com.example.sport_project.classes_for_controllers.WeightCategory;
import com.example.sport_project.db_actions.sportClubDb;
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

public class WindowForWeightCategory implements Initializable {

    @FXML
    private MenuItem data_delete;

    @FXML
    private MenuItem add_weight_category_btn;

    @FXML
    private MenuItem update_table;

    @FXML
    private TableView<WeightCategory> weight_table;

    @FXML
    private TableColumn<WeightCategory, Integer> id_col;

    @FXML
    private TableColumn<WeightCategory, String> weight_col;


    public void updateData(){

        weight_table.getItems().clear();
        // weight_table.setItems(weightCategoryDb.getWeight());
        weight_table.refresh();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        weight_col.setCellValueFactory(new PropertyValueFactory<>("weight"));

        update_table.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateData();
            }
        });

        TableView.TableViewSelectionModel<WeightCategory> selectionModel = weight_table.getSelectionModel();


        data_delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!selectionModel.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Успешно");
                    alert.setHeaderText(null);
                    alert.setContentText("Весовая категория "+ selectionModel.getSelectedItem().getWeight() + " успешно удалена!");
                    alert.showAndWait();
                    weightCategoryDb.deleteWeightCategory(selectionModel.getSelectedItem().getWeight());
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

        add_weight_category_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Platform.runLater(() -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/weightCategoryView.fxml"));
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

    }
}