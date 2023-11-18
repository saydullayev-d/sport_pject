package com.example.sport_project.db_actions;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.Main;

import java.sql.*;

public class winner_1Db {

    public static void addWinner(int id, int winner, String name){
        String query = "INSERT INTO winner_1(id,draw_num, name) VALUES(?,?,?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, winner);
            preparedStatement.setString(3, name);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getByDrawNum(int draw_num){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");){
            String query = "SELECT name FROM winner_1 WHERE draw_num = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,draw_num);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                data = resultSet.getString("name");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static int getSportsmen(int id){
        int data = 0;
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");){
            String query = "SELECT draw_num FROM winner_1 WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                data = resultSet.getInt("draw_num");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static String getName(int id){
        String  data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");){
            String query = "SELECT name FROM winner_1 WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                data = resultSet.getString("name");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public static void clearTable(){
        String query = "DELETE FROM winner_1";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:../resources/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
