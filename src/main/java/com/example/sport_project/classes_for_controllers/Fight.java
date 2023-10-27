package com.example.sport_project.classes_for_controllers;

public class Fight {
    String sportsmen1, sportsmen2;

    public Fight(String sportsmen1, String sportsmen2) {
        this.sportsmen1 = sportsmen1;
        this.sportsmen2 = sportsmen2;
    }

    public String getSportsmen1() {
        return sportsmen1;
    }

    public Fight setSportsmen1(String sportsmen1) {
        this.sportsmen1 = sportsmen1;
        return this;
    }

    public String getSportsmen2() {
        return sportsmen2;
    }

    public Fight setSportsmen2(String sportsmen2) {
        this.sportsmen2 = sportsmen2;
        return this;
    }
}
