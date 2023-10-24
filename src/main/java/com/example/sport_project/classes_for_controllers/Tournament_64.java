package com.example.sport_project.classes_for_controllers;

public class Tournament_64 {
    String name;
    String fight_num;

    public Tournament_64(String name, String fight_num) {
        this.name = name;
        this.fight_num = fight_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFight_num() {
        return fight_num;
    }

    public void setFight_num(String fight_num) {
        this.fight_num = fight_num;
    }
}