module com.example.sport_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;


    opens com.example.sport_project to javafx.fxml;
    exports com.example.sport_project;
    exports com.example.sport_project.controllers;
    opens com.example.sport_project.controllers to javafx.fxml;
}