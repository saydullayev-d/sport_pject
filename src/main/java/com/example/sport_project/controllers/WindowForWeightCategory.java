package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowForWeightCategory implements Initializable {

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
        weight_table.setItems(weightCategoryDb.getWeight());
        weight_table.refresh();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        weight_col.setCellValueFactory(new PropertyValueFactory<>("weight"));

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
