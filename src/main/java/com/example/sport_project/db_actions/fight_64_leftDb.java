package com.example.sport_project.db_actions;

import com.example.sport_project.classes_for_controllers.Fight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class fight_64_leftDb {

    public static void addFight(int id){
        String query = "INSERT INTO fight_64_left(sportsmen1, sportsmen2) VALUES((SELECT name FROM tournament_64 WHERE id = ?),(SELECT name FROM tournament_64 WHERE id = ?))";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id+2);

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static String getSportsmen1(int id){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
            String query = "SELECT sportsmen1 FROM fight_64_left WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                data = resultSet.getString("sportsmen1");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public static String getSportsmen2(int id){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
            String query = "SELECT sportsmen2 FROM fight_64_left WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                data = resultSet.getString("sportsmen2");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
