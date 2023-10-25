package com.example.sport_project.classes_for_controllers;

public class Tournament_64 {
    String name;
    String fight_num;
    int id;

    public Tournament_64(String name, String fight_num, int id) {
        this.name = name;
        this.fight_num = fight_num;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}