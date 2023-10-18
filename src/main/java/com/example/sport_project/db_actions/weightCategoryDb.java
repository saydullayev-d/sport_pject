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
        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        String query = "INSERT INTO weight_category(weight) VALUES(?)";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, club);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static ObservableList<WeightCategory> getWeight(){
        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        ObservableList<WeightCategory> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection(url, login, password)){
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
            System.out.println(e);
        }
        return data;
    }

    public static String getFirst(){

        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        String data = "";
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT weight FROM weight_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String weight = resultSet.getString("weight");
                data = weight;
            }

            return data;
        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }

}
