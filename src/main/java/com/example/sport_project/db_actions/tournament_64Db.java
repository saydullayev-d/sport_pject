package com.example.sport_project.db_actions;

import com.example.sport_project.classes_for_controllers.Tournament_64;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class tournament_64Db {
    public static ObservableList<Tournament_64> getDataLeft(){
        ObservableList<Tournament_64> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
            String query = "SELECT fight_num, name FROM tournament_64 WHERE id % 2 = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String fight_num = resultSet.getString("fight_num");
                data.add(new Tournament_64(name, fight_num));
            }
            return data;

        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }

    public static void addDataLeft(ArrayList<String> sportsmens){
        String query = "INSERT INTO tournament_64(fight_num, name) VALUES(?, ?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (String sportsmen: sportsmens) {
                int index = sportsmens.indexOf(sportsmen)+1;
                preparedStatement.setString(1, "_64_"+index);
                preparedStatement.setString(2, sportsmen);
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
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
