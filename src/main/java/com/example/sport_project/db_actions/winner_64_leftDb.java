package com.example.sport_project.db_actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class winner_64_leftDb {
    public static void addWinner(int id, int winner){
        String query = "INSERT INTO winner_64_left(id,draw_num) VALUES(?,?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, winner);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static int getSportsmen(int id){
        int data = 0;
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
            String query = "SELECT draw_num FROM winner_64_left WHERE id = ?";
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
