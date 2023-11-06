
package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.db_actions.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bracket64 implements Initializable {
    @FXML
    private Text _64_1;
    @FXML
    private Text _64_2;
    @FXML
    private Text _32_1;
    @FXML
    private Text right_32_1;
    @FXML
    private Button fight_left_64_1;
    @FXML
    private Button fight_right_64_1;
    @FXML
    private Text left_win_64_1;
    @FXML
    private Text left_win_32_1;
    @FXML
    private Text left_win_16_1;
    @FXML
    private Tab etap_32;
    @FXML
    private Tab etap_16;
    @FXML
    private Tab etap_8;
    @FXML
    private Tab etap_4;
    @FXML
    private Tab etap_2;
    @FXML
    private Tab etap_1;
    @FXML
    private TabPane bracket_pane;
    @FXML
    private Button print_btn_1;
    @FXML
    private Button fight_left_32_1;
    @FXML
    private Button fight_right_32_1;
    @FXML
    private Button fight_left_16_1;
    @FXML
    private Text left_16_1;
    @FXML
    private Text right_16_1;
    @FXML
    private Text left_8_1;
    @FXML
    private Text right_8_1;

    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vbox3;
    @FXML
    private VBox vbox4;
    @FXML
    private VBox vbox5;
    @FXML
    private VBox vbox6;
    @FXML
    private VBox vbox7;
    @FXML
    private VBox vbox8;
    @FXML
    private VBox vbox9;
    @FXML
    private  VBox vbox10;
    @FXML
    private VBox vbox11;
    @FXML
    private  VBox vbox12;
    @FXML
    private VBox vbox13;
    @FXML
    private VBox vbox14;

    public static int extractLastDigit(String input) {
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String lastDigit = matcher.group();
            return Integer.parseInt(lastDigit);
        } else {
            throw new IllegalArgumentException("Цифры не найдены.");
        }
    }

    static List<Text> left_win_64 = new ArrayList<>();
    static List<Text> right_win_64 = new ArrayList<>();
    static List<Text> left_win_32 = new ArrayList<>();
    static List<Text> right_win_32 = new ArrayList<>();
    static List<Text> left_win_16 = new ArrayList<>();
    static List<Text> right_win_16 = new ArrayList<>();

    public static void addWinner(int id, int sportsmen) {
        for (Text text : left_win_64) {
            if (("left_win_64_" + id).equals(text.getId())) {
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinnerRight(int id, int sportsmen) {
        for (Text text : right_win_64) {

            if (("right_win_64_" + id).equals(text.getId())) {
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinner32Right(int id, int sportsmen) {
        for (Text text : right_win_32) {
            if (("right_win_32_" + id).equals(text.getId())) {
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinner32Left(int id, int sportsmen) {
        for (Text text : left_win_32){
            if (("left_win_32_" + id).equals(text.getId())) {
                text.setText(String.valueOf(sportsmen));
            }
        }
    }

    public static void addWinner16Left(int id, int sportsmen) {
        for (Text text: left_win_16){
            if (("left_win_16_"+id).equals(text.getId())){
                text.setText(String.valueOf(sportsmen));
            }
        }
    }

    public static void addWinner16Right(int id, int sportsmen) {
        for (Text text: right_win_16){
            if (("right_win_16_"+id).equals(text.getId())){
                text.setText(String.valueOf(sportsmen));
            }
        }
    }

    List<Text> textList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        VBox parent = (VBox) _64_1.getParent();
        VBox parent2 = (VBox) _64_2.getParent();
        for (int i = 1; i <= 128; i += 2) {
            Node element = parent.lookup("#_64_" + i);
            textList.add((Text) element);
        }
        for (int i = 2; i <= 128; i += 2) {
            Node element = parent2.lookup("#_64_" + i);
            textList.add((Text) element);
        }
        AnchorPane win_parent = (AnchorPane) left_win_64_1.getParent();
        for (int i = 1; i <= 32; i++) {
            Node left_element = win_parent.lookup("#left_win_64_" + i);
            Node right_element = win_parent.lookup("#right_win_64_" + i);
            left_win_64.add((Text) left_element);
            right_win_64.add((Text) right_element);
        }
        AnchorPane win32_parent = (AnchorPane) left_win_32_1.getParent();
        for(int i = 1; i<=16; i++){
            Node left_element = win32_parent.lookup("#left_win_32_"+i);
            left_win_32.add((Text) left_element);

        }

        for(int i = 1; i<=16; i++){
            Node right_element = win32_parent.lookup("#right_win_32_"+i);
            right_win_32.add((Text) right_element);
        }

        AnchorPane win16_parent = (AnchorPane)  left_win_16_1.getParent();
        for (int i = 1; i <=8 ; i++) {
            Text left_element = (Text) win16_parent.lookup("#left_win_16_"+i);
            Text right_element = (Text) win16_parent.lookup("#right_win_16_"+i);
            left_win_16.add(left_element);
            right_win_16.add(right_element);
        }



        Pattern pattern = Pattern.compile("_64_(\\d+)");
        Comparator<Text> textComparator = (text1, text2) -> {
            Matcher matcher1 = pattern.matcher(text1.getId());
            Matcher matcher2 = pattern.matcher(text2.getId());
            if (matcher1.find() && matcher2.find()) {
                int id1 = Integer.parseInt(matcher1.group(1));
                int id2 = Integer.parseInt(matcher2.group(1));
                return Integer.compare(id1, id2);
            } else {
                return 0;
            }
        };
        textList.sort(textComparator);

        for (Text text : textList) {
            String name = tournament_64Db.getDataLeft(extractLastDigit(text.getId()));
            text.setText(name);
        }

        AnchorPane btn_parent = (AnchorPane) fight_left_64_1.getParent();
        List<Button> btnList = new ArrayList<>();
        for (int i = 1; i <= 32; i++) {
            Node element = btn_parent.lookup("#fight_left_64_" + i);
            btnList.add((Button) element);

        }

        AnchorPane right_btn_parent = (AnchorPane) fight_right_64_1.getParent();
        List<Button> rightBtnList = new ArrayList<>();
        for (int i = 1; i <=32 ; i++) {
            Node element = right_btn_parent.lookup("#fight_right_64_"+i);
            rightBtnList.add((Button) element);
        }
        for(Button btn : rightBtnList){
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    int id = extractLastDigit(btn.getId());
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightRight.fxml"));
                        Scene newscene = new Scene(loader.load());
                        WindowForFightRight windowForFightRight = loader.getController();
                        windowForFightRight.name_winner(tournament_64Db.getByDrawNum(fight_64_rightDb.getSportsmen1(id)), tournament_64Db.getByDrawNum(fight_64_rightDb.getSportsmen2(id)), fight_64_rightDb.getSportsmen1(id), fight_64_rightDb.getSportsmen2(id));
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Результат");
                        newstage.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        for (Button btn : btnList) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    int id = extractLastDigit(btn.getId());
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightLeft.fxml"));
                        Scene newscene = new Scene(loader.load());
                        WindowForFightLeft windowForFightLeft = loader.getController();
                        windowForFightLeft.name_winner(tournament_64Db.getByDrawNum(fight_64_leftDb.getSportsmen1(id)), tournament_64Db.getByDrawNum(fight_64_leftDb.getSportsmen2(id)), fight_64_leftDb.getSportsmen1(id), fight_64_leftDb.getSportsmen2(id));
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Результат");
                        newstage.showAndWait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }
            });
        }

        bracket_pane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab == etap_32) {
                VBox parent32 = (VBox) _32_1.getParent();
                VBox parent32_right = (VBox) right_32_1.getParent();
                for (int i = 1; i <= 32; i++) {
                    Text element = (Text) parent32.lookup("#_32_" + i);
                    Text element_right = (Text) parent32_right.lookup("#right_32_" + i);
                    String draw_num = winner_64_leftDb.getName(i);
                    String draw_num_rigth = winner_64_rightDb.getName(i);
                    element.setText(draw_num);
                    element_right.setText(draw_num_rigth);
                }
                List<Button> buttonList32 = new ArrayList<>();
                List<Button> buttonList32right = new ArrayList<>();
                AnchorPane btn_parent32 = (AnchorPane) fight_left_32_1.getParent();
                for(int i = 1; i<=31; i+=2){
                    Button btn = (Button) btn_parent32.lookup("#fight_left_32_"+i);
                    buttonList32.add(btn);
                }
                for(int i = 1; i<=31; i+=2){
                    Button btn = (Button) btn_parent32.lookup("#fight_right_32_"+i);
                    buttonList32right.add(btn);
                }
                for(Button button: buttonList32){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_64_leftDb.getSportsmen(id);
                            int sportsmen2 = winner_64_leftDb.getSportsmen(id+1);
                            fight_32_leftDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_64_leftDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_64_leftDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightLeft.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightLeft windowForFightLeft = loader.getController();
                                windowForFightLeft.fight32Left(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
                                Stage newstage = new Stage();
                                newstage.setScene(newscene);
                                newstage.setTitle("Результат");
                                newstage.showAndWait();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    });
                }

                for(Button button: buttonList32right){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_64_rightDb.getSportsmen(id);
                            int sportsmen2 = winner_64_rightDb.getSportsmen(id+1);
                            fight_32_rightDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_64_rightDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_64_rightDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightRight.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightRight windowForFightRight = loader.getController();
                                windowForFightRight.fight32Right(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
                                Stage newstage = new Stage();
                                newstage.setScene(newscene);
                                newstage.setTitle("Результат");
                                newstage.showAndWait();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    });
                }


            }
            if (newTab == etap_16){
                VBox parent_16_left = (VBox) left_16_1.getParent();
                VBox parent_16_right = (VBox) right_16_1.getParent();
                for (int i = 1; i<=16; i++){
                    Text element_left = (Text) parent_16_left.lookup("#left_16_"+i);
                    Text element_right = (Text) parent_16_right.lookup("#right_16_"+i);
                    String name_left = winner_32_leftDb.getName(i);
                    String name_right = winner_32_rightDb.getName(i);
                    element_left.setText(name_left);
                    element_right.setText(name_right);
                }
                List<Button> button16Left = new ArrayList<>();
                List<Button> button16Right = new ArrayList<>();
                AnchorPane leftParent = (AnchorPane) fight_left_16_1.getParent();
                for(int i = 1; i<=15; i+=2){
                    Button btnLeft = (Button) leftParent.lookup("#fight_left_16_"+i);
                    Button btnRight = (Button) leftParent.lookup("#fight_right_16_"+i);
                    button16Left.add(btnLeft);
                    button16Right.add(btnRight);
                }

                for(Button button: button16Left){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_32_leftDb.getSportsmen(id);
                            int sportsmen2 = winner_32_leftDb.getSportsmen(id+1);
                            fight_16_leftDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_32_leftDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_32_leftDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightLeft.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightLeft windowForFightLeft = loader.getController();
                                windowForFightLeft.fight16left(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
                                Stage newstage = new Stage();
                                newstage.setScene(newscene);
                                newstage.setTitle("Результат");
                                newstage.showAndWait();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
                for(Button button: button16Right){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_32_rightDb.getSportsmen(id);
                            int sportsmen2 = winner_32_rightDb.getSportsmen(id+1);
                            fight_16_rightDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_32_rightDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_32_rightDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightRight.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightRight windowForFightRight = loader.getController();
                                windowForFightRight.fight16Right(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
                                Stage newstage = new Stage();
                                newstage.setScene(newscene);
                                newstage.setTitle("Результат");
                                newstage.showAndWait();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }

            }
            if (newTab == etap_8){
                VBox parent_8_left = (VBox) left_8_1.getParent();
                VBox parent_8_right = (VBox) right_8_1.getParent();
                for (int i = 1; i<=8; i++){
                    Text element_left = (Text) parent_8_left.lookup("#left_8_"+i);
                    Text element_right = (Text) parent_8_right.lookup("#right_8_"+i);
                    String name_left = winner_16_leftDb.getName(i);
                    String name_right = winner_16_rightDb.getName(i);
                    element_left.setText(name_left);
                    element_right.setText(name_right);
                }
                List<Button> button16Left = new ArrayList<>();
                List<Button> button16Right = new ArrayList<>();
                AnchorPane leftParent = (AnchorPane) fight_left_16_1.getParent();
                for(int i = 1; i<=15; i+=2){
                    Button btnLeft = (Button) leftParent.lookup("#fight_left_16_"+i);
                    Button btnRight = (Button) leftParent.lookup("#fight_right_16_"+i);
                    button16Left.add(btnLeft);
                    button16Right.add(btnRight);
                }
            }

        });
    }



    @FXML
    private void onPrintButtonClicked(ActionEvent event) {
        try {
            String sourceFilePath = "C:/Users/User/Desktop/sport_pject/src/main/resources/files/1-64.xlsx";
            File sourceFile = new File(sourceFilePath);

            if (sourceFile.exists()) {
                FileInputStream templateStream = new FileInputStream(sourceFile);
                Workbook workbook = new XSSFWorkbook(templateStream);

                Sheet sheet = workbook.getSheetAt(0);

                int numRows = 68;  // Количество строк
                int numCols = 26;  // Количество столбцов

                // Создайте список для хранения стилей
                List<List<CellStyle>> cellStyles = new ArrayList<>();
                for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                    List<CellStyle> rowStyles = new ArrayList<>();
                    for (int colIndex = 0; colIndex < numCols; colIndex++) {
                        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
                        if (cell != null) {
                            rowStyles.add(cell.getCellStyle());
                        } else {
                            rowStyles.add(null);
                        }
                    }
                    cellStyles.add(rowStyles);
                }

                // Ваш существующий код для извлечения данных из VBox элементов (vbox1 и vbox2)

                List<String> dataFromVBox1 = new ArrayList<>();
                List<String> dataFromVBox2 = new ArrayList<>();

                for (Node node : vbox1.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox2.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox2.add(((Text) node).getText());
                    }
                }

                // Получите значение left_win_64_1
                String leftWin64_1Value = left_win_64_1.getText();

                // Вставьте данные и стили в Excel
                int maxRows = Math.max(dataFromVBox1.size(), dataFromVBox2.size());

                for (int i = 0; i <= maxRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox1.size()) {
                        Cell cell1 = row.createCell(1);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox1.get(i));
                        if (cellStyles.get(i).get(1) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(1));
                        }
                    }

                    if (i < dataFromVBox2.size()) {
                        Cell cell25 = row.createCell(24);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(24) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(24));
                        }
                    }


                }
                List<Row> rowList = new ArrayList<>();
                for(int i = 0; i < maxRows; i+=2){
                    Row row = sheet.getRow(i);
                    rowList.add(row);
                }
                for(int i = 0; i<rowList.size(); i++){
                    Cell cell3 = rowList.get(i).createCell(3);
                    cell3.setCellValue(winner_64_leftDb.getSportsmen(i+1));
                }

                // Сохранение и закрытие workbook в новый файл
                String outputFile = "C:/Users/User/Desktop/sport_pject/src/main/resources/file/1-64_updated.xlsx";
                try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                    workbook.write(outputStream);
                }

                workbook.close();
                System.out.println("Данные успешно записаны в новый Excel файл: " + outputFile);

                // Откройте новый файл с использованием стандартных средств ОС (в данном случае, Microsoft Excel)
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start excel " + outputFile);
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Исходный файл не найден: " + sourceFilePath);
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при записи в Excel: " + e.getMessage());
        }
    }


    @FXML
    private void onPrintButtonClicked2(ActionEvent event) {
        try {
            String sourceFilePath = "C:/Users/User/Desktop/sport_pject/src/main/resources/files/1-32.xlsx";
            File sourceFile = new File(sourceFilePath);

            if (sourceFile.exists()) {
                FileInputStream templateStream = new FileInputStream(sourceFile);
                Workbook workbook = new XSSFWorkbook(templateStream);

                Sheet sheet = workbook.getSheetAt(0);

                int numRows = 36;  // Количество строк
                int numCols = 26;  // Количество столбцов

                // Создайте список для хранения стилей
                List<List<CellStyle>> cellStyles = new ArrayList<>();
                for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                    List<CellStyle> rowStyles = new ArrayList<>();
                    for (int colIndex = 0; colIndex < numCols; colIndex++) {
                        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
                        if (cell != null) {
                            rowStyles.add(cell.getCellStyle());
                        } else {
                            rowStyles.add(null);
                        }
                    }
                    cellStyles.add(rowStyles);
                }

                // Ваш существующий код для извлечения данных из VBox элементов (vbox1 и vbox2)

                List<String> dataFromVBox1 = new ArrayList<>();
                List<String> dataFromVBox2 = new ArrayList<>();

                for (Node node : vbox3.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox4.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox2.add(((Text) node).getText());
                    }
                }

                // Получите значение left_win_64_1
                String leftWin64_1Value = left_win_64_1.getText();

                // Вставьте данные и стили в Excel
                int maxRows = Math.max(dataFromVBox1.size(), dataFromVBox2.size());

                for (int i = 0; i < maxRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox1.size()) {
                        Cell cell1 = row.createCell(1);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox1.get(i));
                        if (cellStyles.get(i).get(1) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(1));
                        }
                    }

                    if (i < dataFromVBox2.size()) {
                        Cell cell25 = row.createCell(24);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(24) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(24));
                        }
                    }

                    if (i == 0) {
                        // Добавьте значение left_win_64_1 в третий столбец (индекс 2)
                        Cell cell3 = row.createCell(2);
                        cell3.setCellValue(winner_64_leftDb.getSportsmen(i + 1));

                        // Вы можете также применить стиль ячейки, если это необходимо.
                    }
                }

                // Сохранение и закрытие workbook в новый файл
                String outputFile = "C:/Users/User/Desktop/sport_pject/src/main/resources/file/1-32_updated.xlsx";
                try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                    workbook.write(outputStream);
                }

                workbook.close();

                System.out.println("Данные успешно записаны в новый Excel файл: " + outputFile);

// Откройте новый файл с использованием стандартных средств ОС (в данном случае, Microsoft Excel)
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start excel " + outputFile);
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Исходный файл не найден: " + sourceFilePath);
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при записи в Excel: " + e.getMessage());

        }
    }

    @FXML
    private void onPrintButtonClicked3(ActionEvent event) {
        try {
            String sourceFilePath = "C:/Users/User/Desktop/sport_pject/src/main/resources/files/1-16.xlsx";
            File sourceFile = new File(sourceFilePath);

            if (sourceFile.exists()) {
                FileInputStream templateStream = new FileInputStream(sourceFile);
                Workbook workbook = new XSSFWorkbook(templateStream);

                Sheet sheet = workbook.getSheetAt(0);

                int numRows = 18;  // Количество строк
                int numCols = 26;  // Количество столбцов

                // Создайте список для хранения стилей
                List<List<CellStyle>> cellStyles = new ArrayList<>();
                for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                    List<CellStyle> rowStyles = new ArrayList<>();
                    for (int colIndex = 0; colIndex < numCols; colIndex++) {
                        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
                        if (cell != null) {
                            rowStyles.add(cell.getCellStyle());
                        } else {
                            rowStyles.add(null);
                        }
                    }
                    cellStyles.add(rowStyles);
                }

                // Ваш существующий код для извлечения данных из VBox элементов (vbox1 и vbox2)

                List<String> dataFromVBox1 = new ArrayList<>();
                List<String> dataFromVBox2 = new ArrayList<>();

                for (Node node : vbox5.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox6.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox2.add(((Text) node).getText());
                    }
                }

                // Получите значение left_win_64_1
                String leftWin64_1Value = left_win_64_1.getText();

                // Вставьте данные и стили в Excel
                int maxRows = Math.max(dataFromVBox1.size(), dataFromVBox2.size());

                for (int i = 0; i < maxRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox1.size()) {
                        Cell cell1 = row.createCell(1);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox1.get(i));
                        if (cellStyles.get(i).get(1) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(1));
                        }
                    }

                    if (i < dataFromVBox2.size()) {
                        Cell cell25 = row.createCell(24);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(24) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(24));
                        }
                    }

                    if (i == 0) {
                        // Добавьте значение left_win_64_1 в третий столбец (индекс 2)
                        Cell cell3 = row.createCell(2);
                        cell3.setCellValue(winner_64_leftDb.getSportsmen(i + 1));

                        // Вы можете также применить стиль ячейки, если это необходимо.
                    }
                }

                // Сохранение и закрытие workbook в новый файл
                String outputFile = "C:/Users/User/Desktop/sport_pject/src/main/resources/file/1-16_updated.xlsx";
                try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                    workbook.write(outputStream);
                }

                workbook.close();

                System.out.println("Данные успешно записаны в новый Excel файл: " + outputFile);

                // Откройте новый файл с использованием стандартных средств ОС (в данном случае, Microsoft Excel)
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start excel " + outputFile);
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Исходный файл не найден: " + sourceFilePath);
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при записи в Excel: " + e.getMessage());

        }
    }

    @FXML
    private void onPrintButtonClicked4(ActionEvent event) {
        try {
            String sourceFilePath = "C:/Users/User/Desktop/sport_pject/src/main/resources/files/1-8.xlsx";
            File sourceFile = new File(sourceFilePath);

            if (sourceFile.exists()) {
                FileInputStream templateStream = new FileInputStream(sourceFile);
                Workbook workbook = new XSSFWorkbook(templateStream);

                Sheet sheet = workbook.getSheetAt(0);

                int numRows = 10;  // Количество строк
                int numCols = 26;  // Количество столбцов

                // Создайте список для хранения стилей
                List<List<CellStyle>> cellStyles = new ArrayList<>();
                for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                    List<CellStyle> rowStyles = new ArrayList<>();
                    for (int colIndex = 0; colIndex < numCols; colIndex++) {
                        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
                        if (cell != null) {
                            rowStyles.add(cell.getCellStyle());
                        } else {
                            rowStyles.add(null);
                        }
                    }
                    cellStyles.add(rowStyles);
                }

                // Ваш существующий код для извлечения данных из VBox элементов (vbox1 и vbox2)

                List<String> dataFromVBox1 = new ArrayList<>();
                List<String> dataFromVBox2 = new ArrayList<>();

                for (Node node : vbox7.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox8.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox2.add(((Text) node).getText());
                    }
                }

                // Получите значение left_win_64_1
                String leftWin64_1Value = left_win_64_1.getText();

                // Вставьте данные и стили в Excel
                int maxRows = Math.max(dataFromVBox1.size(), dataFromVBox2.size());

                for (int i = 0; i < maxRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox1.size()) {
                        Cell cell1 = row.createCell(1);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox1.get(i));
                        if (cellStyles.get(i).get(1) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(1));
                        }
                    }

                    if (i < dataFromVBox2.size()) {
                        Cell cell25 = row.createCell(24);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(24) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(24));
                        }
                    }

                    if (i == 0) {
                        // Добавьте значение left_win_64_1 в третий столбец (индекс 2)
                        Cell cell3 = row.createCell(2);
                        cell3.setCellValue(winner_64_leftDb.getSportsmen(i + 1));

                        // Вы можете также применить стиль ячейки, если это необходимо.
                    }
                }

                // Сохранение и закрытие workbook в новый файл
                String outputFile = "C:/Users/User/Desktop/sport_pject/src/main/resources/file/1-8_updated.xlsx";
                try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                    workbook.write(outputStream);
                }

                workbook.close();

                System.out.println("Данные успешно записаны в новый Excel файл: " + outputFile);

                // Откройте новый файл с использованием стандартных средств ОС (в данном случае, Microsoft Excel)
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start excel " + outputFile);
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Исходный файл не найден: " + sourceFilePath);
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при записи в Excel: " + e.getMessage());

        }
    }

    @FXML
    private void onPrintButtonClicked5(ActionEvent event) {
        try {
            String sourceFilePath = "C:/Users/User/Desktop/sport_pject/src/main/resources/files/1-4.xlsx";
            File sourceFile = new File(sourceFilePath);

            if (sourceFile.exists()) {
                FileInputStream templateStream = new FileInputStream(sourceFile);
                Workbook workbook = new XSSFWorkbook(templateStream);

                Sheet sheet = workbook.getSheetAt(0);

                int numRows = 6;  // Количество строк
                int numCols = 26;  // Количество столбцов

                // Создайте список для хранения стилей
                List<List<CellStyle>> cellStyles = new ArrayList<>();
                for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                    List<CellStyle> rowStyles = new ArrayList<>();
                    for (int colIndex = 0; colIndex < numCols; colIndex++) {
                        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
                        if (cell != null) {
                            rowStyles.add(cell.getCellStyle());
                        } else {
                            rowStyles.add(null);
                        }
                    }
                    cellStyles.add(rowStyles);
                }

                // Ваш существующий код для извлечения данных из VBox элементов (vbox1 и vbox2)

                List<String> dataFromVBox1 = new ArrayList<>();
                List<String> dataFromVBox2 = new ArrayList<>();

                for (Node node : vbox9.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox10.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox2.add(((Text) node).getText());
                    }
                }

                // Получите значение left_win_64_1
                String leftWin64_1Value = left_win_64_1.getText();

                // Вставьте данные и стили в Excel
                int maxRows = Math.max(dataFromVBox1.size(), dataFromVBox2.size());

                for (int i = 0; i < maxRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox1.size()) {
                        Cell cell1 = row.createCell(1);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox1.get(i));
                        if (cellStyles.get(i).get(1) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(1));
                        }
                    }

                    if (i < dataFromVBox2.size()) {
                        Cell cell25 = row.createCell(24);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(24) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(24));
                        }
                    }

                    if (i == 0) {
                        // Добавьте значение left_win_64_1 в третий столбец (индекс 2)
                        Cell cell3 = row.createCell(2);
                        cell3.setCellValue(winner_64_leftDb.getSportsmen(i + 1));

                        // Вы можете также применить стиль ячейки, если это необходимо.
                    }
                }

                // Сохранение и закрытие workbook в новый файл
                String outputFile = "C:/Users/User/Desktop/sport_pject/src/main/resources/file/1-4_updated.xlsx";
                try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                    workbook.write(outputStream);
                }

                workbook.close();

                System.out.println("Данные успешно записаны в новый Excel файл: " + outputFile);

                // Откройте новый файл с использованием стандартных средств ОС (в данном случае, Microsoft Excel)
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start excel " + outputFile);
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Исходный файл не найден: " + sourceFilePath);
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при записи в Excel: " + e.getMessage());

        }
    }

    @FXML
    private void onPrintButtonClicked6(ActionEvent event) {
        try {
            String sourceFilePath = "C:/Users/User/Desktop/sport_pject/src/main/resources/files/1-2.xlsx";
            File sourceFile = new File(sourceFilePath);

            if (sourceFile.exists()) {
                FileInputStream templateStream = new FileInputStream(sourceFile);
                Workbook workbook = new XSSFWorkbook(templateStream);

                Sheet sheet = workbook.getSheetAt(0);

                int numRows = 4;  // Количество строк
                int numCols = 26;  // Количество столбцов

// Создайте список для хранения стилей
                List<List<CellStyle>> cellStyles = new ArrayList<>();
                for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                    List<CellStyle> rowStyles = new ArrayList<>();
                    for (int colIndex = 0; colIndex < numCols; colIndex++) {
                        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
                        if (cell != null) {
                            rowStyles.add(cell.getCellStyle());
                        } else {
                            rowStyles.add(null);
                        }
                    }
                    cellStyles.add(rowStyles);
                }

                // Ваш существующий код для извлечения данных из VBox элементов (vbox1 и vbox2)

                List<String> dataFromVBox1 = new ArrayList<>();
                List<String> dataFromVBox2 = new ArrayList<>();

                for (Node node : vbox11.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox12.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox2.add(((Text) node).getText());
                    }
                }

                // Получите значение left_win_64_1
                String leftWin64_1Value = left_win_64_1.getText();

                // Вставьте данные и стили в Excel
                int maxRows = Math.max(dataFromVBox1.size(), dataFromVBox2.size());

                for (int i = 0; i < maxRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox1.size()) {
                        Cell cell1 = row.createCell(1);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox1.get(i));
                        if (cellStyles.get(i).get(1) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(1));
                        }
                    }

                    if (i < dataFromVBox2.size()) {
                        Cell cell25 = row.createCell(24);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(24) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(24));
                        }
                    }

                    if (i == 0) {
                        // Добавьте значение left_win_64_1 в третий столбец (индекс 2)
                        Cell cell3 = row.createCell(2);
                        cell3.setCellValue(winner_64_leftDb.getSportsmen(i + 1));

                        // Вы можете также применить стиль ячейки, если это необходимо.
                    }
                }

                // Сохранение и закрытие workbook в новый файл
                String outputFile = "C:/Users/User/Desktop/sport_pject/src/main/resources/file/1-2_updated.xlsx";
                try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                    workbook.write(outputStream);
                }

                workbook.close();

                System.out.println("Данные успешно записаны в новый Excel файл: " + outputFile);

                // Откройте новый файл с использованием стандартных средств ОС (в данном случае, Microsoft Excel)
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start excel " + outputFile);
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Исходный файл не найден: " + sourceFilePath);
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при записи в Excel: " + e.getMessage());

        }
    }

    @FXML
    private void onPrintButtonClicked7(ActionEvent event) {
        try {
            String sourceFilePath = "C:/Users/User/Desktop/sport_pject/src/main/resources/files/final.xlsx";
            File sourceFile = new File(sourceFilePath);

            if (sourceFile.exists()) {
                FileInputStream templateStream = new FileInputStream(sourceFile);
                Workbook workbook = new XSSFWorkbook(templateStream);

                Sheet sheet = workbook.getSheetAt(0);

                int numRows = 2;  // Количество строк
                int numCols = 26;  // Количество столбцов

                // Создайте список для хранения стилей
                List<List<CellStyle>> cellStyles = new ArrayList<>();
                for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                    List<CellStyle> rowStyles = new ArrayList<>();
                    for (int colIndex = 0; colIndex < numCols; colIndex++) {
                        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
                        if (cell != null) {
                            rowStyles.add(cell.getCellStyle());
                        } else {
                            rowStyles.add(null);
                        }
                    }
                    cellStyles.add(rowStyles);
                }

                // Ваш существующий код для извлечения данных из VBox элементов (vbox1 и vbox2)

                List<String> dataFromVBox1 = new ArrayList<>();
                List<String> dataFromVBox2 = new ArrayList<>();

                for (Node node : vbox13.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox14.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox2.add(((Text) node).getText());
                    }
                }

                // Получите значение left_win_64_1
                String leftWin64_1Value = left_win_64_1.getText();

                // Вставьте данные и стили в Excel
                int maxRows = Math.max(dataFromVBox1.size(), dataFromVBox2.size());

                for (int i = 0; i < maxRows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox1.size()) {
                        Cell cell1 = row.createCell(1);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox1.get(i));
                        if (cellStyles.get(i).get(1) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(1));
                        }
                    }

                    if (i < dataFromVBox2.size()) {
                        Cell cell25 = row.createCell(24);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(24) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(24));
                        }
                    }

                    if (i == 0) {
                        // Добавьте значение left_win_64_1 в третий столбец (индекс 2)
                        Cell cell3 = row.createCell(2);
                        int sportsmenId = winner_64_leftDb.getSportsmen(i + 1);
                        System.out.println("sportsmenId: " + sportsmenId); // Добавьте эту строку для отладки
                        cell3.setCellValue(String.valueOf(sportsmenId));

                        // Вы можете также применить стиль ячейки, если это необходимо.
                    }
                }

// Сохранение и закрытие workbook в новый файл
                String outputFile = "C:/Users/User/Desktop/sport_pject/src/main/resources/file/final_updated.xlsx";
                try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                    workbook.write(outputStream);
                }

                workbook.close();

                System.out.println("Данные успешно записаны в новый Excel файл: " + outputFile);

                // Откройте новый файл с использованием стандартных средств ОС (в данном случае, Microsoft Excel)
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c start excel " + outputFile);
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Исходный файл не найден: " + sourceFilePath);
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при записи в Excel: " + e.getMessage());

        }
    }


}