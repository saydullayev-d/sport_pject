package com.example.sport_project.db_actions;

import com.example.sport_project.classes_for_controllers.AgeCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ageCategoryDb {
    public static void addAge(String club){
        String query = "INSERT INTO age_category(age) VALUES(?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, club);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static ObservableList<AgeCategory> getAge(){
        ObservableList<AgeCategory> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db")){
            String query = "SELECT id, age FROM age_category";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String age = resultSet.getString("age");
                int id = resultSet.getInt("id");
                data.add(new AgeCategory(id, age));
            }
            return data;
        }catch (Exception e){
            System.out.println(e);
        }

        return data;

    }

    public static void deleteAgeCategory(String age) {
        String query = "DELETE FROM age_category WHERE age = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, age);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update_ageCategory(String ageCategory_old, String club){
        String query = "UPDATE  age_category SET age = ? WHERE age = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, club);
            preparedStatement.setString(2, ageCategory_old);
            preparedStatement.executeUpdate();

        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public static String getFirst(){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
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
