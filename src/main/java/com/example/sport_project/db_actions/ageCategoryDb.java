package com.example.sport_project.db_actions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ageCategoryDb {
    public static void addAge(String club){
        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        String query = "INSERT INTO age_category(age) VALUES(?)";

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

    public static ObservableList<String> getAge(){
        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        ObservableList<String> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT age FROM age_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String age = resultSet.getString("age");
                data.add(age);
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
            String query = "SELECT age FROM age_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String age = resultSet.getString("age");
                data = age;
            }

            return data;
        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
}
