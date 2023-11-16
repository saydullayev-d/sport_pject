
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
import org.apache.poi.ss.formula.functions.T;
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
    private Text draw_64_1;
    @FXML
    private Text draw_64_2;
    @FXML
    private Text draw_32_1;
    @FXML
    private Text club_64_1;
    @FXML
    private Text club_64_2;
    @FXML
    private Text right_32_1;
    @FXML
    private Text club_32_1;
    @FXML
    private Text draw_16_1;
    @FXML
    private Text left_club_16_1;
    @FXML
    private Text right_draw_16_1;
    @FXML
    private Text right_club_16_1;
    @FXML
    private Text right_club_32_1;
    @FXML
    private Text right_draw_32_1;
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
    private Text right_win_8_1;
    @FXML
    private Text draw_8_1;
    @FXML
    private Text club_8_1;
    @FXML
    private Text draw_4_1;
    @FXML
    private Text club_4_1;
    @FXML
    private Text right_draw_4_1;
    @FXML
    private Text club_right_4_1;
    @FXML
    private Text right_draw_8_1;
    @FXML
    private Text club_right_8_1;
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
    private Button fight_left_8_1;
    @FXML
    private Button fight_left_4_1;
    @FXML
    private Button fight_left_2_1;
    @FXML
    private Button fight_1_1;
    @FXML
    private Text left_16_1;
    @FXML
    private Text right_16_1;
    @FXML
    private Text left_8_1;
    @FXML
    private Text right_8_1;
    @FXML
    private Text left_4_1;
    @FXML
    private Text right_4_1;
    @FXML
    private Text left_win_4_1;
    @FXML
    private Text left_win_4_2;
    @FXML
    private Text right_win_4_1;
    @FXML
    private Text right_win_4_2;
    @FXML
    private Text left_2_1;
    @FXML
    private Text right_2_1;
    @FXML
    private Text left_win_2_1;
    @FXML
    private Text right_win_2_1;
    @FXML
    private Text left_1_1;
    @FXML
    private Text right_1_1;
    @FXML
    private Text champion;


    @FXML
    private VBox vbox_64_1;
    @FXML
    private VBox vbox_64_2;
    @FXML
    private VBox vbox_32_1;
    @FXML
    private VBox vbox_32_2;
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
    @FXML
    private VBox vbox_draw_32_1;
    @FXML
    private VBox vbox_draw_32_2;
    @FXML
    private VBox vbox_draw_16_1;
    @FXML
    private VBox vbox_draw_16_2;
    @FXML
    private VBox vbox_16_1;
    @FXML
    private VBox vbox_16_2;
    @FXML
    private VBox vbox_8_1;
    @FXML
    private VBox vbox_8_2;
    @FXML
    private VBox vbox_draw_8_1;
    @FXML
    private VBox vbox_draw_8_2;
    @FXML
    private VBox vbox_draw_4_1;
    @FXML
    private VBox vbox_draw_4_2;
    @FXML
    private VBox vbox_4_1;
    @FXML
    private VBox vbox_4_2;
    @FXML
    private VBox vbox_draw_2_1;
    @FXML
    private VBox vbox_draw_2_2;
    @FXML
    private VBox vbox_2_1;
    @FXML
    private VBox vbox_2_2;
    @FXML
    private VBox vbox_draw_1_1;
    @FXML
    private VBox vbox_draw_1_2;
    @FXML
    private VBox vbox_1_1;
    @FXML
    private VBox vbox_1_2;

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
    static List<Text> right_win_8 = new ArrayList<>();
    static List<Text> left_win_8 = new ArrayList<>();
    static List<Text> left_win_4 = new ArrayList<>();
    static List<Text> right_win_4 = new ArrayList<>();
    static List<Text> right_win_2 = new ArrayList<>();
    static List<Text> left_win_2 = new ArrayList<>();
    static List<Text> champion_text = new ArrayList<>();


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

    public static void addWinner8Right(int id, int sportsmen){
        for (Text text: right_win_8){
            if (("right_win_8_"+id).equals(text.getId())){
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinner8Left(int id, int sportsmen){
        for (Text text: left_win_8){
            if (("left_win_8_"+id).equals(text.getId())){
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinner4Right(int id, int sportsmen){
        for (Text text: right_win_4){
            if (("right_win_4_"+id).equals(text.getId())){
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinner4Left(int id, int sportsmen){
        for (Text text: left_win_4){
            if (("left_win_4_"+id).equals(text.getId())){
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinner2Left(int id, int sportsmen){
        for (Text text: left_win_2){
            if (("left_win_2_"+id).equals(text.getId())){
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinner2Right(int id, int sportsmen){
        for (Text text: right_win_2){
            if (("right_win_2_"+id).equals(text.getId())){
                text.setText(String.valueOf(sportsmen));
            }
        }
    }
    public static void addWinnerFinal(int sportsmen){
        for (Text text: champion_text){
            text.setText(String.valueOf(sportsmen));
        }
    }

    List<Text> textList = new ArrayList<>();
    List<Text> drawNumList = new ArrayList<>();
    List<Text> clubList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        left_win_4.add(left_win_4_1);
        left_win_4.add(left_win_4_2);
        right_win_4.add(right_win_4_1);
        right_win_4.add(right_win_4_2);
        left_win_2.add(left_win_2_1);
        right_win_2.add(right_win_2_1);
        champion_text.add(champion);

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

        VBox drawParent = (VBox) draw_64_1.getParent();
        VBox drawParentRight = (VBox) draw_64_2.getParent();
        for(int i = 1; i<=128; i+=2){
            Node element = drawParent.lookup("#draw_64_"+i);
            drawNumList.add((Text) element);
        }
        for(int i = 2; i<=128; i+=2){
            Node element = drawParentRight.lookup("#draw_64_"+i);
            drawNumList.add((Text) element);
        }
        VBox clubParent = (VBox) club_64_1.getParent();
        VBox clubParentRight = (VBox) club_64_2.getParent();
        for(int i = 1; i<=128; i+=2){
            Node element = clubParent.lookup("#club_64_"+i);
            clubList.add((Text) element);
        }
        for(int i = 2; i<=128; i+=2){
            Node element = clubParentRight.lookup("#club_64_"+i);
            clubList.add((Text) element);
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
        AnchorPane win8_parent = (AnchorPane) right_win_8_1.getParent();
        for (int i = 1; i <=4; i++) {
            Text right_element = (Text) win8_parent.lookup("#right_win_8_"+i);
            Text left_element = (Text) win8_parent.lookup("#left_win_8_"+i);
            left_win_8.add(left_element);
            right_win_8.add(right_element);
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

        for(Text text : drawNumList){
            if(text != null){
                text.setText(String.valueOf(extractLastDigit(text.getId())));
            }
        }
        for(Text text : clubList){
            if(text != null) {
                String club = tournament_64Db.getSportClub(extractLastDigit(text.getId()));
                text.setText(club);
            }
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
                        e.printStackTrace();
                    }

                }
            });
        }

        bracket_pane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab == etap_32) {
                VBox parent32 = (VBox) _32_1.getParent();
                VBox parent32_right = (VBox) right_32_1.getParent();
                VBox parent32_draw_left = (VBox) draw_32_1.getParent();
                VBox parent32_club_left = (VBox) club_32_1.getParent();
                VBox parent32_draw_right = (VBox) right_draw_32_1.getParent();
                VBox parent_32_club_right = (VBox) right_club_32_1.getParent();

                for (int i = 1; i <= 32; i++) {
                    Text element = (Text) parent32.lookup("#_32_" + i);
                    Text element_right = (Text) parent32_right.lookup("#right_32_" + i);
                    Text draw = (Text) parent32_draw_left.lookup("#draw_32_"+i);
                    Text club = (Text) parent32_club_left.lookup("#club_32_"+i);
                    Text draw_r = (Text) parent32_draw_right.lookup("#right_draw_32_"+i);
                    Text club_r = (Text) parent_32_club_right.lookup("#right_club_32_"+i);
                    String draw_num = winner_64_leftDb.getName(i);
                    String draw_num_rigth = winner_64_rightDb.getName(i);
                    int draw_left = winner_64_leftDb.getSportsmen(i);
                    int draw_right = winner_64_rightDb.getSportsmen(i);
                    String club_right = winner_64_rightDb.getClub(i);
                    String sportclub = winner_64_leftDb.getClub(i);
                    draw.setText(String.valueOf(draw_left));
                    element.setText(draw_num);
                    element_right.setText(draw_num_rigth);
                    club.setText(sportclub);
                    draw_r.setText(String.valueOf(draw_right));
                    club_r.setText(club_right);
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
                VBox parent16_draw_left = (VBox) draw_16_1.getParent();
                VBox parent16_club_left = (VBox) left_club_16_1.getParent();
                VBox parent16_club_right = (VBox) right_club_16_1.getParent();
                VBox parent16_draw_right = (VBox) right_draw_16_1.getParent();

                for (int i = 1; i<=16; i++){
                    Text element_left = (Text) parent_16_left.lookup("#left_16_"+i);
                    Text element_right = (Text) parent_16_right.lookup("#right_16_"+i);
                    Text draw_left = (Text) parent16_draw_left.lookup("#draw_16_"+i);
                    Text club_left = (Text) parent16_club_left.lookup("#left_club_16_"+i);
                    Text club_right = (Text) parent16_club_right.lookup("#right_club_16_"+i);
                    Text draw_right = (Text) parent16_draw_right.lookup("#right_draw_16_"+i);
                    String club = winner_32_leftDb.getClub(i);
                    String name_left = winner_32_leftDb.getName(i);
                    String name_right = winner_32_rightDb.getName(i);
                    int drawLeft = winner_32_leftDb.getSportsmen(i);
                    int draw_r = winner_32_rightDb.getSportsmen(i);
                    String club_r = winner_32_rightDb.getClub(i);
                    element_left.setText(name_left);
                    element_right.setText(name_right);
                    draw_left.setText(String.valueOf(drawLeft));
                    club_left.setText(club);
                    club_right.setText(club_r);
                    draw_right.setText(String.valueOf(draw_r));
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
                VBox parent8_draw_left = (VBox) draw_8_1.getParent();
                VBox parent8_club_left = (VBox) club_8_1.getParent();
                VBox parent8_draw_right = (VBox) right_draw_8_1.getParent();
                VBox parent8_club_right = (VBox) club_right_8_1.getParent();

                for (int i = 1; i<=8; i++){
                    Text element_left = (Text) parent_8_left.lookup("#left_8_"+i);
                    Text element_right = (Text) parent_8_right.lookup("#right_8_"+i);
                    Text draw_left = (Text) parent8_draw_left.lookup("#draw_8_"+i);
                    Text club_left = (Text) parent8_club_left.lookup("#club_8_"+i);
                    Text draw_right = (Text) parent8_draw_right.lookup("#right_draw_8_"+i);
                    Text club_right = (Text) parent8_club_right.lookup("#club_right_8_"+i);

                    String name_left = winner_16_leftDb.getName(i);
                    String name_right = winner_16_rightDb.getName(i);
                    int draw_l = winner_16_leftDb.getSportsmen(i);
                    String club_l = winner_16_leftDb.getClub(i);
                    int draw_r = winner_16_rightDb.getSportsmen(i);
                    String club_r = winner_16_rightDb.getClub(i);
                    draw_left.setText(String.valueOf(draw_l));
                    club_left.setText(club_l);
                    draw_right.setText(String.valueOf(draw_r));
                    club_right.setText(club_r);
                    element_left.setText(name_left);
                    element_right.setText(name_right);
                }
                List<Button> button8Left = new ArrayList<>();
                List<Button> button8Right = new ArrayList<>();
                AnchorPane leftParent = (AnchorPane) fight_left_8_1.getParent();
                for(int i = 1; i<=7; i+=2){
                    Button btnLeft = (Button) leftParent.lookup("#fight_left_8_"+i);
                    Button btnRight = (Button) leftParent.lookup("#fight_right_8_"+i);
                    button8Left.add(btnLeft);
                    button8Right.add(btnRight);
                }

                for (Button button: button8Right){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_16_rightDb.getSportsmen(id);
                            int sportsmen2 = winner_16_rightDb.getSportsmen(id+1);
                            fight_8_rightDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_16_rightDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_16_rightDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightRight.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightRight windowForFightRight = loader.getController();
                                windowForFightRight.fight8Right(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
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

                for(Button button: button8Left){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_16_leftDb.getSportsmen(id);
                            int sportsmen2 = winner_16_leftDb.getSportsmen(id+1);
                            fight_8_leftDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_16_leftDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_16_leftDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightLeft.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightLeft windowForFightLeft = loader.getController();
                                windowForFightLeft.fight8Left(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
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
            if (newTab == etap_4){
                VBox parent_4_left = (VBox) left_4_1.getParent();
                VBox parent_4_right = (VBox) right_4_1.getParent();
                VBox parent4_draw_left = (VBox) draw_4_1.getParent();
                VBox parent4_club_left = (VBox) club_4_1.getParent();
                VBox parent4_draw_right = (VBox) right_draw_4_1.getParent();
                VBox parent4_club_right = (VBox) club_right_4_1.getParent();

                for (int i = 1; i<=4; i++){
                    Text element_left = (Text) parent_4_left.lookup("#left_4_"+i);
                    Text element_right = (Text) parent_4_right.lookup("#right_4_"+i);
                    Text draw_right = (Text) parent4_draw_right.lookup("#right_draw_4_"+i);
                    Text draw_left = (Text) parent4_draw_left.lookup("#draw_4_"+i);
                    Text club_left = (Text) parent4_club_left.lookup("#club_4_"+i);
                    Text club_right = (Text) parent4_club_right.lookup("#club_right_4_"+i);
                    String name_left = winner_8_leftDb.getName(i);
                    String name_right = winner_8_rightDb.getName(i);
                    int draw_r = winner_16_rightDb.getSportsmen(i);
                    int draw_l = winner_16_leftDb.getSportsmen(i);
                    String club_r = winner_16_rightDb.getClub(i);
                    String club_l = winner_16_leftDb.getClub(i);
                    draw_right.setText(String.valueOf(draw_r));
                    draw_left.setText(String.valueOf(draw_l));
                    club_left.setText(club_l);
                    club_right.setText(club_r);


                    element_left.setText(name_left);
                    element_right.setText(name_right);
                }
                List<Button> button4Left = new ArrayList<>();
                List<Button> button4Right = new ArrayList<>();
                AnchorPane leftParent = (AnchorPane) fight_left_4_1.getParent();
                for(int i = 1; i<=3; i+=2){
                    Button btnLeft = (Button) leftParent.lookup("#fight_left_4_"+i);
                    Button btnRight = (Button) leftParent.lookup("#fight_right_4_"+i);
                    button4Left.add(btnLeft);
                    button4Right.add(btnRight);
                }

                for (Button button: button4Right){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_8_rightDb.getSportsmen(id);
                            int sportsmen2 = winner_8_rightDb.getSportsmen(id+1);
                            fight_4_rightDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_8_rightDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_8_rightDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightRight.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightRight windowForFightRight = loader.getController();
                                windowForFightRight.fight4Right(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
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

                for(Button button: button4Left){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_8_leftDb.getSportsmen(id);
                            int sportsmen2 = winner_8_leftDb.getSportsmen(id+1);
                            fight_4_leftDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_8_leftDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_8_leftDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightLeft.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightLeft windowForFightLeft = loader.getController();
                                windowForFightLeft.fight4Left(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
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
            if (newTab == etap_2){
                VBox parent_2_left = (VBox) left_2_1.getParent();
                VBox parent_2_right = (VBox) right_2_1.getParent();
                for (int i = 1; i<=2; i++){
                    Text element_left = (Text) parent_2_left.lookup("#left_2_"+i);
                    Text element_right = (Text) parent_2_right.lookup("#right_2_"+i);
                    String name_left = winner_4_leftDb.getName(i);
                    String name_right = winner_4_rightDb.getName(i);
                    element_left.setText(name_left);
                    element_right.setText(name_right);
                }
                List<Button> button2Left = new ArrayList<>();
                List<Button> button2Right = new ArrayList<>();
                AnchorPane leftParent = (AnchorPane) fight_left_2_1.getParent();
                Button btnLeft = (Button) leftParent.lookup("#fight_left_2_1");
                Button btnRight = (Button) leftParent.lookup("#fight_right_2_1");
                button2Left.add(btnLeft);
                button2Right.add(btnRight);

                for (Button button: button2Right){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_4_rightDb.getSportsmen(id);
                            int sportsmen2 = winner_4_rightDb.getSportsmen(id+1);
                            fight_2_rightDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_4_rightDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_4_rightDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightRight.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightRight windowForFightRight = loader.getController();
                                windowForFightRight.fight2Right(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
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

                for(Button button: button2Left){
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            int id = extractLastDigit(button.getId());
                            int sportsmen1 = winner_4_leftDb.getSportsmen(id);
                            int sportsmen2 = winner_4_leftDb.getSportsmen(id+1);
                            fight_2_leftDb.addFight(sportsmen1, sportsmen2);
                            String sportsmen1_name = winner_4_leftDb.getByDrawNum(sportsmen1);
                            String sportsmen2_name = winner_4_leftDb.getByDrawNum(sportsmen2);
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFightLeft.fxml"));
                            try {
                                Scene newscene = new Scene(loader.load());
                                WindowForFightLeft windowForFightLeft = loader.getController();
                                windowForFightLeft.fight2Left(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
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
            if (newTab == etap_1){

                String name_left = winner_4_leftDb.getName(1);
                String name_right = winner_4_rightDb.getName(1);
                left_1_1.setText(name_left);
                right_1_1.setText(name_right);




                fight_1_1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int id = 1;
                        int sportsmen2 = winner_2_rightDb.getSportsmen(id);
                        int sportsmen1 = winner_2_leftDb.getSportsmen(id);
                        fight_1Db.addFight(sportsmen1, sportsmen2);
                        String sportsmen2_name = winner_2_rightDb.getByDrawNum(sportsmen2);
                        String sportsmen1_name = winner_2_leftDb.getByDrawNum(sportsmen1);
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFinal.fxml"));
                        try {
                            Scene newscene = new Scene(loader.load());
                            WindowForFinal windowForFinal = loader.getController();
                            windowForFinal.name_winner(sportsmen1_name, sportsmen2_name, sportsmen1, sportsmen2);
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

                int numRows = 65;  // Количество строк
                int numCols = 13;

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
                    }else {
                        dataFromVBox1.add("");
                    }
                }

                for (Node node : vbox2.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox2.add(((Text) node).getText());
                    }else {
                        dataFromVBox2.add("");
                    }
                }

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
                        Cell cell25 = row.createCell(11);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(11) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(11));
                        }
                    }


                }
                List<Row> rowList = new ArrayList<>();
                for(int i = 0; i < maxRows; i+=2){
                    Row row = sheet.getRow(i);
                    rowList.add(row);
                }
                for(int i = 0; i<rowList.size(); i++){
                    Cell cell3 = rowList.get(i).createCell(4);
                    if(winner_64_leftDb.getSportsmen(i+1)!=0) {
                        cell3.setCellValue(winner_64_leftDb.getSportsmen(i + 1));
                    }
                    Cell cell4 = rowList.get(i).createCell(8);
                    if(winner_64_rightDb.getSportsmen(i + 1)!=0) {
                        cell4.setCellValue(winner_64_rightDb.getSportsmen(i + 1));
                    }
                }

                List<String> dataFromVBox64_1 = new ArrayList<>();
                List<String> dataFromVBox64_2 = new ArrayList<>();

                for (Node node : vbox_64_1.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox64_1.add(((Text) node).getText());
                    }else {
                        dataFromVBox64_1.add("");
                    }
                }

                for (Node node : vbox_64_2.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox64_2.add(((Text) node).getText());
                    }else {
                        dataFromVBox64_2.add("");
                    }
                }

                // Вставьте данные и стили в Excel
                int maxRows2 = Math.max(dataFromVBox64_1.size(), dataFromVBox64_2.size());

                for (int i = 0; i <= maxRows2; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox64_1.size()) {
                        Cell cell1 = row.createCell(2);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox64_1.get(i));
                        if (cellStyles.get(i).get(2) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(2));
                        }
                    }

                    if (i < dataFromVBox64_2.size()) {
                        Cell cell25 = row.createCell(10);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox64_2.get(i));
                        if (cellStyles.get(i).get(10) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(10));
                        }
                    }


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

                int numRows = 32;  // Количество строк
                int numCols = 14;  // Количество столбцов

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
                String leftWin64_1Value = left_win_32_1.getText();

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
                        Cell cell25 = row.createCell(11);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(11) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(11));
                        }
                    }


                }
                List<Row> rowList = new ArrayList<>();
                for (int i = 0; i < maxRows; i += 2) {
                    Row row = sheet.getRow(i);
                    rowList.add(row);
                }
                for (int i = 0; i < rowList.size(); i++) {
                    Cell cell3 = rowList.get(i).createCell(4);
                    if(winner_32_leftDb.getSportsmen(i + 1)!=0) {
                        cell3.setCellValue(winner_32_leftDb.getSportsmen(i + 1));
                    }
                    Cell cell4 = rowList.get(i).createCell(8);
                    if(winner_32_rightDb.getSportsmen(i + 1)!=0) {
                        cell4.setCellValue(winner_32_rightDb.getSportsmen(i + 1));
                    }
                }


                List<String> dataFromVBox32_1 = new ArrayList<>();
                List<String> dataFromVBox32_2 = new ArrayList<>();
                List<String> dataFromVBox_draw32_1 = new ArrayList<>();
                List<String> dataFromVBox_draw32_2 = new ArrayList<>();

                for (Node node : vbox_32_1.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox32_1.add(((Text) node).getText());
                    }else {
                        dataFromVBox32_1.add("");
                    }
                }

                for (Node node : vbox_32_2.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox32_2.add(((Text) node).getText());
                    }else {
                        dataFromVBox32_2.add("");
                    }
                }

                for (Node node : vbox_draw_32_1.getChildren()){
                    if (node instanceof Text) {
                        dataFromVBox_draw32_1.add(((Text) node).getText());
                    }
                    else {
                        dataFromVBox_draw32_1.add("");
                    }
                }
                for (Node node : vbox_draw_32_2.getChildren()){
                    if (node instanceof Text) {
                        dataFromVBox_draw32_2.add(((Text) node).getText());
                    }
                    else {
                        dataFromVBox_draw32_2.add("");
                    }
                }

                // Вставьте данные и стили в Excel
                int maxRows2 = Math.max(dataFromVBox32_1.size(), dataFromVBox32_2.size());

                for (int i = 0; i <= maxRows2; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) {
                        row = sheet.createRow(i);
                    }

                    if (i < dataFromVBox32_1.size()) {
                        Cell cell1 = row.createCell(2);  // Столбец 2 (индекс 1)
                        cell1.setCellValue(dataFromVBox32_1.get(i));
                        if (cellStyles.get(i).get(2) != null) {
                            cell1.setCellStyle(cellStyles.get(i).get(2));
                        }
                    }

                    if (i < dataFromVBox32_2.size()) {
                        Cell cell25 = row.createCell(10);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox32_2.get(i));
                        if (cellStyles.get(i).get(10) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(10));
                        }
                    }

                    if (i < dataFromVBox_draw32_1.size()){
                        Cell cell0 = row.createCell(0);
                        cell0.setCellValue(dataFromVBox_draw32_1.get(i));
                        if (cellStyles.get(i).get(0) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(0));
                        }
                    }

                    if (i < dataFromVBox_draw32_2.size()){
                        Cell cell0 = row.createCell(12);
                        cell0.setCellValue(dataFromVBox_draw32_2.get(i));
                        if (cellStyles.get(i).get(12) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(12));
                        }
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

                int numRows = 16;  // Количество строк
                int numCols = 14;  // Количество столбцов

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
                List<String> dataFromVBox_draw16_1 = new ArrayList<>();
                List<String> dataFromVBox_draw16_2 = new ArrayList<>();
                List<String> dataFromVbox_16_1 = new ArrayList<>();
                List<String> dataFromVbox_16_2 = new ArrayList<>();

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

                for (Node node : vbox_draw_16_1.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox_draw16_1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox_draw_16_2.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVBox_draw16_2.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox_16_1.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVbox_16_1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox_16_2.getChildren()) {
                    if (node instanceof Text) {
                        dataFromVbox_16_2.add(((Text) node).getText());
                    }
                }


                // Получите значение left_win_64_1
                String leftWin64_1Value = left_win_16_1.getText();

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
                        Cell cell25 = row.createCell(11);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(11) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(11));
                        }
                    }

                    if (i < dataFromVBox_draw16_1.size()){
                        Cell cell0 = row.createCell(0);
                        cell0.setCellValue(dataFromVBox_draw16_1.get(i));
                        if (cellStyles.get(i).get(0) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(0));
                        }
                    }

                    if (i < dataFromVBox_draw16_2.size()){
                        Cell cell0 = row.createCell(12);
                        cell0.setCellValue(dataFromVBox_draw16_2.get(i));
                        if (cellStyles.get(i).get(12) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(12));
                        }
                    }

                    if (i < dataFromVbox_16_1.size()){
                        Cell cell0 = row.createCell(2);
                        cell0.setCellValue(dataFromVbox_16_1.get(i));
                        if (cellStyles.get(i).get(2) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(2));
                        }
                    }
                    if (i < dataFromVbox_16_2.size()){
                        Cell cell0 = row.createCell(10);
                        cell0.setCellValue(dataFromVbox_16_2.get(i));
                        if (cellStyles.get(i).get(10) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(10));
                        }
                    }


                }
                List<Row> rowList = new ArrayList<>();
                for (int i = 0; i < maxRows; i += 2) {
                    Row row = sheet.getRow(i);
                    rowList.add(row);
                }
                for (int i = 0; i < rowList.size(); i++) {
                    Cell cell3 = rowList.get(i).createCell(4);
                    if(winner_16_leftDb.getSportsmen(i + 1)!=0) {
                        cell3.setCellValue(winner_16_leftDb.getSportsmen(i + 1));
                    }
                    Cell cell4 = rowList.get(i).createCell(8);
                    if(winner_16_rightDb.getSportsmen(i + 1)!=0) {
                        cell4.setCellValue(winner_16_rightDb.getSportsmen(i + 1));
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

                int numRows = 8;  // Количество строк
                int numCols = 14;  // Количество столбцов

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
                List<String> dataFromVBox_draw_8_1 = new ArrayList<>();
                List<String> dataFromVBox_draw_8_2 = new ArrayList<>();
                List<String> dataFromVBox_8_1 = new ArrayList<>();
                List<String> dataFromVBox_8_2 = new ArrayList<>();

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

                for (Node node : vbox_draw_8_1.getChildren()){
                    if (node instanceof Text){
                        dataFromVBox_draw_8_1.add(((Text) node).getText());
                    }
                }
                for (Node node : vbox_draw_8_2.getChildren()){
                    if (node instanceof Text){
                        dataFromVBox_draw_8_2.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox_8_1.getChildren()){
                    if (node instanceof Text){
                        dataFromVBox_8_1.add(((Text) node).getText());
                    }
                }
                for (Node node : vbox_8_2.getChildren()){
                    if (node instanceof Text){
                        dataFromVBox_8_2.add(((Text) node).getText());
                    }
                }


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
                        Cell cell25 = row.createCell(11);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(11) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(11));
                        }
                    }

                    if (i < dataFromVBox_8_1.size()){
                        Cell cellclub = row.createCell(2);
                        cellclub.setCellValue(dataFromVBox_8_1.get(i));
                        if (cellStyles.get(i).get(2) != null) {
                            cellclub.setCellStyle(cellStyles.get(i).get(2));
                        }
                    }

                    if (i < dataFromVBox_8_2.size()){
                        Cell cellclub = row.createCell(10);
                        cellclub.setCellValue(dataFromVBox_8_1.get(i));
                        if (cellStyles.get(i).get(10) != null) {
                            cellclub.setCellStyle(cellStyles.get(i).get(10));
                        }
                    }

                    if (i < dataFromVBox_draw_8_1.size()){
                        Cell cellclub = row.createCell(0);
                        cellclub.setCellValue(dataFromVBox_draw_8_1.get(i));
                        if (cellStyles.get(i).get(0) != null) {
                            cellclub.setCellStyle(cellStyles.get(i).get(0));
                        }
                    }

                    if (i < dataFromVBox_draw_8_2.size()){
                        Cell cellclub = row.createCell(12);
                        cellclub.setCellValue(dataFromVBox_draw_8_2.get(i));
                        if (cellStyles.get(i).get(12) != null) {
                            cellclub.setCellStyle(cellStyles.get(i).get(12));
                        }
                    }


                }
                List<Row> rowList = new ArrayList<>();
                for (int i = 0; i < maxRows; i += 2) {
                    Row row = sheet.getRow(i);
                    rowList.add(row);
                }
                for (int i = 0; i < rowList.size(); i++) {
                    Cell cell3 = rowList.get(i).createCell(4);
                    if(winner_8_leftDb.getSportsmen(i + 1)!=0) {
                        cell3.setCellValue(winner_8_leftDb.getSportsmen(i + 1));
                    }
                    Cell cell4 = rowList.get(i).createCell(8);
                    if(winner_8_rightDb.getSportsmen(i + 1)!=0){
                        cell4.setCellValue(winner_8_rightDb.getSportsmen(i + 1));
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

                int numRows = 4;  // Количество строк
                int numCols = 14;  // Количество столбцов

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
                List<String> dataFromVBox_draw4_1 = new ArrayList<>();
                List<String> dataFromVBox_draw4_2 = new ArrayList<>();
                List<String> dataFromVBox_4_1 = new ArrayList<>();
                List<String> dataFromVBox_4_2 = new ArrayList<>();

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

                for (Node node : vbox_draw_4_1.getChildren()){
                    if (node instanceof Text){
                        dataFromVBox_draw4_1.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox_draw_4_2.getChildren()){
                    if (node instanceof Text){
                        dataFromVBox_draw4_2.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox_4_2.getChildren()){
                    if (node instanceof Text){
                        dataFromVBox_4_2.add(((Text) node).getText());
                    }
                }

                for (Node node : vbox_4_1.getChildren()){
                    if (node instanceof Text){
                        dataFromVBox_4_1.add(((Text) node).getText());
                    }
                }


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
                        Cell cell25 = row.createCell(11);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(11) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(11));
                        }
                    }

                    if (i < dataFromVBox_draw4_1.size()) {
                        Cell cell0 = row.createCell(0);  // Столбец 25 (индекс 24)
                        cell0.setCellValue(dataFromVBox_draw4_1.get(i));
                        if (cellStyles.get(i).get(0) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(0));
                        }
                    }
                    if (i < dataFromVBox_draw4_2.size()) {
                        Cell cell0 = row.createCell(12);  // Столбец 25 (индекс 24)
                        cell0.setCellValue(dataFromVBox_draw4_2.get(i));
                        if (cellStyles.get(i).get(12) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(12));
                        }
                    }
                    if (i < dataFromVBox_4_1.size()) {
                        Cell cell0 = row.createCell(2);  // Столбец 25 (индекс 24)
                        cell0.setCellValue(dataFromVBox_4_1.get(i));
                        if (cellStyles.get(i).get(2) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(2));
                        }
                    }
                    if (i < dataFromVBox_4_2.size()) {
                        Cell cell0 = row.createCell(10);  // Столбец 25 (индекс 24)
                        cell0.setCellValue(dataFromVBox_4_2.get(i));
                        if (cellStyles.get(i).get(10) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(10));
                        }
                    }


                }
                List<Row> rowList = new ArrayList<>();
                for (int i = 0; i < maxRows; i += 2) {
                    Row row = sheet.getRow(i);
                    rowList.add(row);
                }
                for (int i = 0; i < rowList.size(); i++) {
                    Cell cell3 = rowList.get(i).createCell(4);
                    if(winner_4_leftDb.getSportsmen(i + 1)!=0){
                        cell3.setCellValue(winner_4_leftDb.getSportsmen(i + 1));
                    }
                    Cell cell4 = rowList.get(i).createCell(8);
                    if(winner_4_rightDb.getSportsmen(i + 1)!=0){
                        cell4.setCellValue(winner_4_rightDb.getSportsmen(i + 1));
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

                int numRows = 2;  // Количество строк
                int numCols = 14;  // Количество столбцов

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
                List<String> dataFromVbox_2_1 = new ArrayList<>();
                List<String> dataFromVbox_2_2 = new ArrayList<>();
                List<String> dataFromVbox_draw2_1 = new ArrayList<>();
                List<String> dataFromVbox_draw2_2 = new ArrayList<>();

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

                for (Node node : vbox_2_1.getChildren()){
                    if (node instanceof Text){
                        dataFromVbox_2_1.add(((Text) node).getText());
                    }
                }
                for (Node node : vbox_2_2.getChildren()){
                    if (node instanceof Text){
                        dataFromVbox_2_2.add(((Text) node).getText());
                    }
                }
                for (Node node : vbox_draw_2_1.getChildren()){
                    if (node instanceof Text){
                        dataFromVbox_draw2_1.add(((Text) node).getText());
                    }
                }
                for (Node node : vbox_draw_2_2.getChildren()){
                    if (node instanceof Text){
                        dataFromVbox_draw2_2.add(((Text) node).getText());
                    }
                }


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
                        Cell cell25 = row.createCell(11);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(11) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(11));
                        }
                    }

                    if (i < dataFromVbox_2_1.size()) {
                        Cell cell2 = row.createCell(2);  // Столбец 25 (индекс 24)
                        cell2.setCellValue(dataFromVbox_2_1.get(i));
                        if (cellStyles.get(i).get(2) != null) {
                            cell2.setCellStyle(cellStyles.get(i).get(2));
                        }
                    }
                    if (i < dataFromVbox_2_2.size()) {
                        Cell cell10 = row.createCell(10);  // Столбец 25 (индекс 24)
                        cell10.setCellValue(dataFromVbox_2_2.get(i));
                        if (cellStyles.get(i).get(10) != null) {
                            cell10.setCellStyle(cellStyles.get(i).get(10));
                        }
                    }


                    if (i < dataFromVbox_draw2_1.size()) {
                        Cell cell0 = row.createCell(0);  // Столбец 25 (индекс 24)
                        cell0.setCellValue(dataFromVbox_draw2_1.get(i));
                        if (cellStyles.get(i).get(0) != null) {
                            cell0.setCellStyle(cellStyles.get(i).get(0));
                        }
                    }
                    if (i < dataFromVbox_draw2_2.size()) {
                        Cell cell12 = row.createCell(12);  // Столбец 25 (индекс 24)
                        cell12.setCellValue(dataFromVbox_draw2_2.get(i));
                        if (cellStyles.get(i).get(12) != null) {
                            cell12.setCellStyle(cellStyles.get(i).get(12));
                        }
                    }



                }
                List<Row> rowList = new ArrayList<>();
                for (int i = 0; i < maxRows; i += 2) {
                    Row row = sheet.getRow(i);
                    rowList.add(row);
                }
                for (int i = 0; i < rowList.size(); i++) {
                    Cell cell3 = rowList.get(i).createCell(4);
                    if(winner_2_leftDb.getSportsmen(i + 1)!=0) {
                        cell3.setCellValue(winner_2_leftDb.getSportsmen(i + 1));
                    }
                    Cell cell4 = rowList.get(i).createCell(8);
                    if(winner_2_rightDb.getSportsmen(i + 1)!=0) {
                        cell4.setCellValue(winner_2_rightDb.getSportsmen(i + 1));
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
                int numCols = 14;  // Количество столбцов

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
                        Cell cell25 = row.createCell(11);  // Столбец 25 (индекс 24)
                        cell25.setCellValue(dataFromVBox2.get(i));
                        if (cellStyles.get(i).get(11) != null) {
                            cell25.setCellStyle(cellStyles.get(i).get(11));
                        }
                    }


                }
                List<Row> rowList = new ArrayList<>();

                Row row = sheet.getRow(0);
                rowList.add(row);

                for (int i = 0; i < rowList.size(); i++) {
                    Cell cell3 = rowList.get(i).createCell(6);
                    if(winner_1Db.getSportsmen(i + 1)!=0) {
                        cell3.setCellValue(winner_1Db.getSportsmen(i + 1));
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