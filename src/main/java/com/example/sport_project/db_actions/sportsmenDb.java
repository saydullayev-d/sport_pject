package com.example.sport_project.db_actions;

import com.example.sport_project.classes_for_controllers.Sportsmen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;


public class sportsmenDb {

    public static void write(String name, int cod_draw, String age, String club, String gender, boolean action, String weight, String age_category){
        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        String query = "INSERT INTO sportsmens(name, cod_draw, age, club, gender, action, weight, age_category) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, cod_draw);
            preparedStatement.setDate(3, java.sql.Date.valueOf(age));
            preparedStatement.setString(4, club);
            preparedStatement.setString(5, gender);
            if(action==true){
                preparedStatement.setString(6, "ДА");
            }else {
                preparedStatement.setString(6, "НЕТ");
            }
            preparedStatement.setString(7, weight);
            preparedStatement.setString(8, age_category);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void updateSportsmen(String name_first, String name, int cod_draw, String age, String club, String gender, boolean action, String weight, String age_category){

        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        String query = "UPDATE sportsmens SET name=?, cod_draw=?, age=?, club=?, gender=?, action=?, weight=?, age_category=? WHERE name = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, cod_draw);
            preparedStatement.setDate(3, java.sql.Date.valueOf(age));
            preparedStatement.setString(4, club);
            preparedStatement.setString(5, gender);
            if(action==true){
                preparedStatement.setString(6, "ДА");
            }else {
                preparedStatement.setString(6, "НЕТ");
            }
            preparedStatement.setString(7, weight);
            preparedStatement.setString(8, age_category);
            preparedStatement.setString(9, name_first);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static ObservableList<Sportsmen> getData(){
        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT name, cod_reg, cod_draw, age, club, gender, action, weight, age_category FROM sportsmens";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("name");
                int cod_reg = resultSet.getInt("cod_reg");
                int cod_draw = resultSet.getInt("cod_draw");
                Date age = resultSet.getDate("age");
                String club = resultSet.getString("club");
                String gender = resultSet.getString("gender");
                String action = resultSet.getString("action");
                String weight = resultSet.getString("weight");
                String age_category = resultSet.getString("age_category");
                data.add(new Sportsmen(name, club, gender, weight, age_category, age.toString(), cod_draw, cod_reg, action));
            }

            return data;

        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }

    public static ArrayList<String> getNames() {
        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        ArrayList<String> data = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, login, password)){
            String query = "SELECT name FROM sportsmens";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("name");
                data.add(name);
            }
            return data;

        }catch (Exception e){
            System.out.println(e);
        }
        return data;
    }

    public static void deleteSportsmen(String name) {
        String url = "jdbc:postgresql://localhost:5432/SportProg";
        String login = "progers";
        String password = "root";
        String query = "DELETE FROM sportsmens WHERE name = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

