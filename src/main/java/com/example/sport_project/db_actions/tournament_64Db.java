package com.example.sport_project.db_actions;

import com.example.sport_project.classes_for_controllers.Sportsmen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class tournament_64Db {
//    public ObservableList<Sportsmen> getDataLeft(){
//        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
//        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
//            String query = "SELECT fight_num, name FROM tournament_64";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                String name = resultSet.getString("name");
//                data.add();
//            }
//            return data;
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return data;
//    }

    public static void addDataLeft(ArrayList<String> sportsmens){
        String query = "INSERT INTO tournament_64(fight_num, name) VALUES(?, ?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (String sportsmen: sportsmens) {
                preparedStatement.setInt(1, sportsmens.indexOf(sportsmen)+1);
                preparedStatement.setString(2, sportsmen);
                preparedStatement.addBatch();
                preparedStatement.executeBatch();

            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}