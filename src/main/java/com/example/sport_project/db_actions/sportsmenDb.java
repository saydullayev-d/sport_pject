package com.example.sport_project.db_actions;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.Main;
import com.example.sport_project.classes_for_controllers.Fighter;
import com.example.sport_project.classes_for_controllers.Sportsmen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;


public class sportsmenDb {

    public static void write(String name, int cod_draw, String age, String club, String gender, boolean action, String weight, String age_category){
        ObservableList<Sportsmen> data = FXCollections.observableArrayList();

        String query = "INSERT INTO sportsmen(name, cod_draw, age, club, gender, action, weight, age_category) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, cod_draw);
            preparedStatement.setString(3, age);
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
            e.printStackTrace();
        }

    }

    public static ArrayList<Fighter> getByWeight(String weight){
        ArrayList<Fighter> sportsmens = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");){
            String query = "SELECT name, cod_draw, club FROM sportsmen WHERE weight=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, weight);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int draw_num = resultSet.getInt("cod_draw");
                String sport_club = resultSet.getString("club");
                sportsmens.add(new Fighter(name, draw_num,sport_club));
            }
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sportsmens;
    }


    public static String getByDrawNum(int draw_num){
        String sportsmen = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");){
            String query = "SELECT name FROM sportsmen WHERE cod_draw=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, draw_num);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sportsmen = resultSet.getString("name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sportsmen;
    }


        public static void updateSportsmen(String name_first, String name, int cod_draw, String age, String club, String gender, boolean action, String weight, String age_category){

        String query = "UPDATE sportsmen SET name=?, cod_draw=?, age=?, club=?, gender=?, action=?, weight=?, age_category=? WHERE name = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");
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
            e.printStackTrace();
        }

    }
    public static ObservableList<Sportsmen> getData(){
        ObservableList<Sportsmen> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db")){
            String query = "SELECT name, cod_reg, cod_draw, age, club, gender, action, weight, age_category FROM sportsmen";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int cod_reg = resultSet.getInt("cod_reg");
                int cod_draw = resultSet.getInt("cod_draw");
                String age = resultSet.getString("age");
                String club = resultSet.getString("club");
                String gender = resultSet.getString("gender");
                String action = resultSet.getString("action");
                String weight = resultSet.getString("weight");
                String age_category = resultSet.getString("age_category");
                data.add(new Sportsmen(name, club, gender, weight, age_category, age.toString(), cod_draw, cod_reg, action));
            }
            return data;

        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static ArrayList<String> getNames() {

        ArrayList<String> data = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db")){
            String query = "SELECT name FROM sportsmen";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("name");
                data.add(name);
            }
            return data;

        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static void deleteSportsmen(String name) {

        String query = "DELETE FROM sportsmen WHERE name = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getClub(int draw_num, String name){
        String club = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db")){
            String query = "SELECT club FROM sportsmen WHERE cod_draw=? AND name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, draw_num);
            preparedStatement.setString(2, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                club = resultSet.getString("club");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return club;
    }
}

