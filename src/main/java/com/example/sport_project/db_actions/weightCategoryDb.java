package com.example.sport_project.db_actions;

import com.example.sport_project.classes_for_controllers.WeightCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class weightCategoryDb {

    public static void addWeight(String club){
        String query = "INSERT INTO weight_category(weight) VALUES(?)";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, club);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ObservableList<WeightCategory> getWeight(){
        ObservableList<WeightCategory> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db")){
            String query = "SELECT id, weight FROM weight_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String weight = resultSet.getString("weight");
                int id = resultSet.getInt("id");
                data.add(new WeightCategory(id, weight));
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static ObservableList<WeightCategory> Weight(){
        ObservableList<WeightCategory> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db")){
            String query = "SELECT weight FROM weight_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String weight = resultSet.getString("weight");

                data.add(new WeightCategory(weight));
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }


    public static void update_weight(String weight_old, String weight){
        String query = "UPDATE  weight_category SET weight = ? WHERE weight = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, weight);
            preparedStatement.setString(2, weight_old);
            preparedStatement.executeUpdate();

        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public static void deleteWeightCategory(String weight) {

        String query = "DELETE FROM weight_category WHERE weight = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, weight);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFirst(){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db")){
            String query = "SELECT weight FROM weight_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String weight = resultSet.getString("weight");
                data = weight;
            }

            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

}
