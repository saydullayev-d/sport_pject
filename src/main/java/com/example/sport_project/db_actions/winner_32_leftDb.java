package com.example.sport_project.db_actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class winner_32_leftDb {
    public static void addWinner(int id, int winner, String name){
        String query = "INSERT INTO winner_32_left(id,draw_num, name) VALUES(?,?,?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, winner);
            preparedStatement.setString(3, name);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static String getByDrawNum(int draw_num){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
            String query = "SELECT name FROM winner_32_left WHERE draw_num = ?";
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
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
            String query = "SELECT draw_num FROM winner_32_left WHERE id = ?";
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
}
