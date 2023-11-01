package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.Tournament_64;
import com.example.sport_project.db_actions.sportsmenDb;
import com.example.sport_project.db_actions.tournament_64Db;
import com.example.sport_project.db_actions.fight_64_leftDb;
import com.example.sport_project.db_actions.winner_64_leftDb;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
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
    private Button fight_left_64_1;
    @FXML
    private Button fight_right_64_1;
    @FXML
    private Text left_win_64_1;
    @FXML
    private Tab etap_32;
    @FXML
    private Tab etap_64;
    @FXML
    private TabPane bracket_pane;

    @FXML
    private Button print_btn_1;

    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;

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

    public static void addWinner(int id, int sportsmen) {
        for (Text text : left_win_64) {
            if (("left_win_64_" + id).equals(text.getId())) {
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
            Node element = win_parent.lookup("#left_win_64_" + i);
            left_win_64.add((Text) element);
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

//        AnchorPane right_btn_parent = (AnchorPane) fight_right_64_1.getParent();
//        List<Button> RightbtnList = new ArrayList<>();
//        for (int i = 1; i <=32 ; i++) {
//            Node element = right_btn_parent.lookup("#fight_left_64_"+i);
//            RightbtnList.add((Button) element);
//
//        }

        for (Button btn : btnList) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    int id = extractLastDigit(btn.getId());
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFight.fxml"));
                        Scene newscene = new Scene(loader.load());
                        WindowForFight windowForFight = loader.getController();
                        windowForFight.name_winner(sportsmenDb.getByDrawNum(fight_64_leftDb.getSportsmen1(id)), sportsmenDb.getByDrawNum(fight_64_leftDb.getSportsmen2(id)), fight_64_leftDb.getSportsmen1(id), fight_64_leftDb.getSportsmen2(id));
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
        tournament_64Db.clearTable();
        bracket_pane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab == etap_32) {
                VBox parent32 = (VBox) _32_1.getParent();
                for (int i = 1; i <= 32; i++) {
                    Text element = (Text) parent32.lookup("#_32_" + i);
                    int draw_num = winner_64_leftDb.getSportsmen(i);
                    System.out.println(draw_num);
                    element.setText(String.valueOf(draw_num));
                }

            }
        });

    }

    @FXML
    private void onPrintButtonClicked(ActionEvent event) {
        try {
            Workbook workbook = new XSSFWorkbook(); // Создаем новую книгу Excel

            Sheet sheet = workbook.createSheet("Турнир 64 - VBox Data"); // Создаем лист для данных

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

            // Определите максимальное количество строк между данными из vbox1 и vbox2
            int maxRows = Math.max(dataFromVBox1.size(), dataFromVBox2.size());

            // Записываем данные из vbox1 в первый столбец и добавляем пустой столбец
            for (int i = 0; i < maxRows; i++) {
                Row row = sheet.createRow(i);

                // Записываем данные из vbox1 в первый столбец
                if (i < dataFromVBox1.size()) {
                    Cell cell1 = row.createCell(0);
                    cell1.setCellValue(dataFromVBox1.get(i));
                }

                // Создаем пустой столбец (второй столбец)
                Cell emptyCell = row.createCell(1);

                // Записываем данные из vbox2 в третий столбец
                if (i < dataFromVBox2.size()) {
                    Cell cell2 = row.createCell(2);
                    cell2.setCellValue(dataFromVBox2.get(i));
                }
            }

            // Открываем диалоговое окно для сохранения Excel файла
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                try (FileOutputStream outputStream = new FileOutputStream(file)) {
                    workbook.write(outputStream);
                }

                workbook.close();

                System.out.println("Данные успешно экспортированы в Excel файл: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при экспорте в Excel: " + e.getMessage());
        }
    }
}



