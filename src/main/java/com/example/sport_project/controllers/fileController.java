package com.example.sport_project.controllers;

import com.example.sport_project.classes_for_controllers.Sportsmen;
import com.example.sport_project.db_actions.sportsmenDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.fxml.FXML;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;



public class fileController implements Initializable {

    @FXML
    private TableView<Sportsmen> excel_table;

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
    @FXML
    private Button confirm_btn;
    @FXML
    private Button cancel_btn;

    ObservableList<Sportsmen> data = FXCollections.observableArrayList();
    public void insertData(File selectedFile){
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(selectedFile.getPath());
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Sportsmen sportsmen = new Sportsmen();
                int reg_num = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
                int draw_num = (int) sheet.getRow(i).getCell(5).getNumericCellValue();
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
               // String action = sheet.getRow(i).getCell(3).getStringCellValue();
                double  dateValue = sheet.getRow(i).getCell(2).getNumericCellValue();
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//                String birthDate = dateFormat.format(dateValue);
                String gender = sheet.getRow(i).getCell(3).getStringCellValue();
                String sport_club = sheet.getRow(i).getCell(4).getStringCellValue();
                String weight_category = sheet.getRow(i).getCell(7).getStringCellValue();
                String age_category = sheet.getRow(i).getCell(6).getStringCellValue();
                sportsmen.setReg_num(reg_num);
                sportsmen.setDraw_num(draw_num);
                sportsmen.setName(name);
                sportsmen.setAct("ДА");
                sportsmen.setAge(String.valueOf(dateValue));
                sportsmen.setGender(gender);
                sportsmen.setSport_club(sport_club);
                sportsmen.setWeight(weight_category);
                sportsmen.setAge_category(age_category);
                data.add(sportsmen);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        excel_table.setItems(data);





    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        weight_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("weight"));
        reg_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, Integer>("reg_num"));
        age_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("age_category"));
        name_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("name"));
        gender_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("gender"));
        draw_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("draw_num"));
        date_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("age"));
        club_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, String>("sport_club"));
        act_col.setCellValueFactory(new PropertyValueFactory<Sportsmen, Boolean>("act"));



        confirm_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!data.isEmpty()){
                    for(Sportsmen sportsmen : data){
                        if(sportsmen.getAct().equals("ДА")){
                            sportsmenDb.write(sportsmen.getName(),sportsmen.getDraw_num(),sportsmen.getAge(), sportsmen.getSport_club(), sportsmen.getGender(), true, sportsmen.getWeight(), sportsmen.getAge_category());
                        } else if (sportsmen.getAct().equals("НЕТ")) {
                            sportsmenDb.write(sportsmen.getName(),sportsmen.getDraw_num(),sportsmen.getAge(), sportsmen.getSport_club(), sportsmen.getGender(), false, sportsmen.getWeight(), sportsmen.getAge_category());
                        }
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Успешно");
                    alert.setHeaderText(null);
                    alert.setContentText("Спортсмены успешно добавлены!");
                    alert.showAndWait();
                    data.clear();
                    excel_table.getItems().clear();
                    Stage stage = (Stage) confirm_btn.getScene().getWindow();
                    stage.close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText(null);
                    alert.setContentText("Таблица пуста!");
                    alert.showAndWait();
                }

            }
        });
        cancel_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.clear();
                excel_table.getItems().clear();
                Stage stage = (Stage) cancel_btn.getScene().getWindow();
                stage.close();
            }
        });


    }
}