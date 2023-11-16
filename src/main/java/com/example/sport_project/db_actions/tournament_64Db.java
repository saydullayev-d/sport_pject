package com.example.sport_project.db_actions;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.Main;
import com.example.sport_project.classes_for_controllers.Fighter;
import com.example.sport_project.classes_for_controllers.Tournament_64;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class tournament_64Db {
    public static String getDataLeft(int draw_num){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());){
            String query = "SELECT name FROM tournament_64 WHERE draw_num = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, draw_num);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                data = resultSet.getString("name");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static String getSportClub(int draw_num){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());){
            String query = "SELECT club FROM tournament_64 WHERE draw_num = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, draw_num);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                data = resultSet.getString("club");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static String getByDrawNum(int draw_num){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());){
            String query = "SELECT name FROM tournament_64 WHERE draw_num = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setInt(1, draw_num);
            preparedStatement.executeQuery();
            if (resultSet.next()){

                data = resultSet.getString("name");
                return data;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static void addDataLeft(ArrayList<Fighter> sportsmens){
        String query = "INSERT INTO tournament_64(fight_num, name, draw_num, club) VALUES(?, ?, ?, ?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (Fighter sportsmen: sportsmens) {
                int index = sportsmens.indexOf(sportsmen)+1;
                preparedStatement.setString(1, "_64_"+index);
                preparedStatement.setString(2, sportsmen.getName());
                preparedStatement.setInt(3, sportsmen.getDraw_num());
                preparedStatement.setString(4, sportsmen.getSport_club());
                preparedStatement.addBatch();
                preparedStatement.executeBatch();



            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearTable(){
        String query = "DELETE FROM tournament_64";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}