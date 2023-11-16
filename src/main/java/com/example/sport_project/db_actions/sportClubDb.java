package com.example.sport_project.db_actions;

import com.example.sport_project.HelloApplication;
import com.example.sport_project.Main;
import com.example.sport_project.classes_for_controllers.SportClub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sportClubDb {
    public static void addSportCLub(String club){

        String query = "INSERT INTO sportclub(club) VALUES(?)";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, club);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ObservableList<SportClub> getSportClub(){

        ObservableList<SportClub> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath())){
            String query = "SELECT club_id, club FROM sportclub";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String club = resultSet.getString("club");
                int id = resultSet.getInt("club_id");
                data.add(new SportClub(id, club));
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static ObservableList<SportClub> SportClub(){

        ObservableList<SportClub> data = FXCollections.observableArrayList();
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath())){
            String query = "SELECT club FROM sportclub";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String club = resultSet.getString("club");
                data.add(new SportClub(club));
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }


    public static void deleteSportClub(String club) {

        String query = "DELETE FROM sportclub WHERE club = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, club);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update_SportClub(String SportClub_old, String club){

        String query = "UPDATE  sportclub SET club = ? WHERE club = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, club);
            preparedStatement.setString(2, SportClub_old);
            preparedStatement.executeUpdate();

        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public static String getFirst(){

        String data = "";

        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:"+ Main.class.getResource("/database/sportsmens.db").getPath())){
            String query = "SELECT club FROM sportclub";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String club = resultSet.getString("club");
                data = club;
            }

            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
