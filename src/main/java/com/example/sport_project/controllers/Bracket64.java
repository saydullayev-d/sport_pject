package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.classes_for_controllers.Tournament_64;
import com.example.sport_project.db_actions.tournament_64Db;
import com.example.sport_project.db_actions.fight_64_leftDb;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private Button fight_left_64_1;


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

    List<Text> textList = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        VBox parent = (VBox) _64_1.getParent();
        VBox parent2 = (VBox) _64_2.getParent();
        for (int i = 1; i <=128 ; i+=2) {
            Node element = parent.lookup("#_64_"+i);
            textList.add((Text) element);

        }
        for(int i = 2; i<=128; i+=2){
            Node element = parent2.lookup("#_64_"+i);
            textList.add((Text) element);
        }
        ObservableList<Tournament_64> sportsmens = tournament_64Db.getDataLeft();
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
        for(int i = 0; i < sportsmens.size(); i++){
            String name = sportsmens.get(i).getName();
            String fight_num = sportsmens.get(i).getFight_num();
            if(textList.get(i).getId().equals(fight_num)) {
                textList.get(i).setText(name);
            }
        }
        for (int i = 0; i < sportsmens.size(); i++) {
                if (i % 2 == 0) {
                    fight_64_leftDb.addFight(sportsmens.get(i).getName(), i);
                }
        }


        AnchorPane btn_parent = (AnchorPane) fight_left_64_1.getParent();
        List<Button> btnList = new ArrayList<>();
        for (int i = 1; i <=32 ; i++) {
            Node element = btn_parent.lookup("#fight_left_64_"+i);
            btnList.add((Button) element);

        }
        for(Button btn:btnList){
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    int id = extractLastDigit(btn.getId())+1;
                    String f_id = sportsmens.get(id-1).getFight_num();
                    String f_id2 = sportsmens.get(id+1).getFight_num();
                    System.out.println(f_id);
                    System.out.println(f_id2);
                    String t_id = "_64_"+id;

                    if(t_id.equals(f_id)){
                        String name1 = fight_64_leftDb.getSportsmens(id+1);
                        String name2 = fight_64_leftDb.getSportsmens(id-1);
//                        String name2 = sportsmens.get(id-2).getName();
//                        System.out.println(name1);
//                        System.out.println(name2);

                    }
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/windowForFight.fxml"));
                        Scene newscene = new Scene(loader.load());
                        WindowForFight windowForFight = loader.getController();
                        windowForFight.name_winner(_64_1.getText(), _64_2.getText());
                        Stage newstage = new Stage();
                        newstage.setScene(newscene);
                        newstage.setTitle("Результат");
                        newstage.showAndWait();

                    }catch (Exception e){
                        System.out.println(e);
                    }

                }
            });
        }

    }
}