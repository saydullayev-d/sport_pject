package com.example.sport_project.db_actions;

import java.sql.*;
import java.util.ArrayList;

public class fight_64_leftDb {

    public static void addFight(String sportsmen1, int id){
        String query = "INSERT INTO fight_64_left(id, sportsmen1) VALUES(?,?)";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, sportsmen1);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static String getSportsmens(int id){
        String sportsmen = "";
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/example/sport_project/database/sportsmens.db");){
            String query = "SELECT sportsmen1 FROM fight_64_left WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                sportsmen = name;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sportsmen;
    }
}
