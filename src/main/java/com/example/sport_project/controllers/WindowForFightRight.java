package com.example.sport_project.controllers;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.db_actions.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WindowForFightRight implements Initializable {
    @FXML
    private Button win_1_btn;

    @FXML
    private Button win_2_btn;

    @FXML
    private Text win_sportsmen_2;

    @FXML
    private Text win_sportsmen_1;
    @FXML
    private Text draw_num1;

    @FXML
    private Text draw_num2;


    public void name_winner(String Sportsmen1, String Sportsmen2, int draw_num1, int draw_num2){
        win_sportsmen_1.setText(Sportsmen1);
        win_sportsmen_2.setText(Sportsmen2);
        this.draw_num1.setText(String.valueOf(draw_num1));
        this.draw_num2.setText(String.valueOf(draw_num2));
    }


    public void fight32Right(String Sportsmen1, String Sportsmen2, int draw1, int draw2){
        name_winner(Sportsmen1, Sportsmen2, draw1, draw2);
        win_1_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int winner_draw = Integer.parseInt(draw_num1.getText());
                int looser_draw = Integer.parseInt(draw_num2.getText());
                String name = win_sportsmen_1.getText();
                int id = fight_32_rightDb.getId(winner_draw,looser_draw);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    Bracket64.addWinner32Right(id, winner_draw);
                    winner_32_rightDb.addWinner(id, winner_draw, name);
                    Stage btn_stage = (Stage) win_1_btn.getScene().getWindow();
                    btn_stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        win_2_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int winner_draw = Integer.parseInt(draw_num2.getText());
                int looser_draw = Integer.parseInt(draw_num1.getText());
                String name = win_sportsmen_2.getText();
                int id = fight_32_rightDb.getId(looser_draw,winner_draw);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    Bracket64.addWinner32Right(id, winner_draw);
                    winner_32_rightDb.addWinner(id, winner_draw, name);
                    Stage btn_stage = (Stage) win_2_btn.getScene().getWindow();
                    btn_stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void fight16Right(String Sportsmen1, String Sportsmen2, int draw1, int draw2){
        name_winner(Sportsmen1, Sportsmen2, draw1, draw2);
        win_1_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int winner_draw = Integer.parseInt(draw_num1.getText());
                int looser_draw = Integer.parseInt(draw_num2.getText());
                String name = win_sportsmen_1.getText();
                int id = fight_16_rightDb.getId(winner_draw,looser_draw);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    Bracket64.addWinner16Right(id, winner_draw);
                    winner_16_rightDb.addWinner(id, winner_draw, name);
                    Stage btn_stage = (Stage) win_1_btn.getScene().getWindow();
                    btn_stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        win_2_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int winner_draw = Integer.parseInt(draw_num2.getText());
                int looser_draw = Integer.parseInt(draw_num1.getText());
                String name = win_sportsmen_2.getText();
                int id = fight_16_rightDb.getId(looser_draw,winner_draw);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    Bracket64.addWinner16Right(id, winner_draw);
                    winner_16_rightDb.addWinner(id, winner_draw, name);
                    Stage btn_stage = (Stage) win_2_btn.getScene().getWindow();
                    btn_stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void fight8Right(String Sportsmen1, String Sportsmen2, int draw1, int draw2){
        name_winner(Sportsmen1, Sportsmen2, draw1, draw2);
        win_1_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int winner_draw = Integer.parseInt(draw_num1.getText());
                int looser_draw = Integer.parseInt(draw_num2.getText());
                String name = win_sportsmen_1.getText();
                int id = fight_8_rightDb.getId(winner_draw,looser_draw);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    Bracket64.addWinner8Right(id, winner_draw);
                    winner_8_rightDb.addWinner(id, winner_draw, name);
                    Stage btn_stage = (Stage) win_1_btn.getScene().getWindow();
                    btn_stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        win_2_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int winner_draw = Integer.parseInt(draw_num2.getText());
                int looser_draw = Integer.parseInt(draw_num1.getText());
                String name = win_sportsmen_2.getText();
                int id = fight_8_rightDb.getId(looser_draw,winner_draw);
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    Bracket64.addWinner8Right(id, winner_draw);
                    winner_8_rightDb.addWinner(id, winner_draw, name);
                    Stage btn_stage = (Stage) win_2_btn.getScene().getWindow();
                    btn_stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        win_1_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int winner_draw = Integer.parseInt(draw_num1.getText());
                int looser_draw = Integer.parseInt(draw_num2.getText());
                int id = fight_64_rightDb.getId(winner_draw,looser_draw);
                String name = win_sportsmen_1.getText();
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    Bracket64.addWinnerRight(id, winner_draw);
                    winner_64_rightDb.addWinner(id, winner_draw, name);
                    Stage btn_stage = (Stage) win_1_btn.getScene().getWindow();
                    btn_stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        win_2_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int winner_draw = Integer.parseInt(draw_num2.getText());
                int looser_draw = Integer.parseInt(draw_num1.getText());
                int id = fight_64_rightDb.getId(looser_draw,winner_draw);
                String name = win_sportsmen_2.getText();
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml_files/bracket_64.fxml"));
                try {
                    Scene newscene = new Scene(loader.load());
                    Bracket64.addWinnerRight(id, winner_draw);
                    winner_64_rightDb.addWinner(id, winner_draw, name);
                    Stage btn_stage = (Stage) win_2_btn.getScene().getWindow();
                    btn_stage.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
