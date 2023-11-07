package com.example.sport_project.db_actions;

import java.sql.*;

public class fight_1Db {

    public static void addFight(int sportsmen1, int sportsmen2) {
        String query = "INSERT INTO fight_1(sportsmen1, sportsmen2) VALUES(?,?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sportsmen1);
            preparedStatement.setInt(2, sportsmen2);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static int getSportsmen1(int id){
        int data = 0;
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
            String query = "SELECT sportsmen1 FROM fight_1 WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                data = resultSet.getInt("sportsmen1");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public static int getSportsmen2(int id){
        int data = 0;
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db")){
            String query = "SELECT sportsmen2 FROM fight_1 WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                data = resultSet.getInt("sportsmen2");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static int getId(int sportsmen1, int sportsmen2){
        int id = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            String query = "SELECT id FROM fight_1 WHERE sportsmen1=? AND sportsmen2=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sportsmen1);
            preparedStatement.setInt(2, sportsmen2);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt("id");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
    public static void clearTable(){
        String query = "DELETE FROM fight_1";
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
