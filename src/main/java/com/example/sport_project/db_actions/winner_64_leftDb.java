package com.example.sport_project.db_actions;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.Main;

import java.sql.*;

public class winner_64_leftDb {
    public static void addWinner(int id, int winner, String name, String club){
        String query = "INSERT INTO winner_64_left(id,draw_num, name, club) VALUES(?,?,?,?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, winner);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, club);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getByDrawNum(int draw_num){
        String data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());){
            String query = "SELECT name FROM winner_64_left WHERE draw_num = ?";
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
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());){
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
    public static String getName(int id){
        String  data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());){
            String query = "SELECT name FROM winner_64_left WHERE id = ?";
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

    public static String getClub(int id){
        String  data = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());){
            String query = "SELECT club FROM winner_64_left WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                data = resultSet.getString("club");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static void clearTable(){
        String query = "DELETE FROM winner_64_left";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
