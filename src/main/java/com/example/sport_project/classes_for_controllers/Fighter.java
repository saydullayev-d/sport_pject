package com.example.sport_project.classes_for_controllers;

public class Fighter {
    String name;
    int draw_num;
    String sport_club;

    public Fighter(String name, int draw_num, String sport_club) {
        this.name = name;
        this.draw_num = draw_num;
        this.sport_club = sport_club;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDraw_num() {
        return draw_num;
    }

    public void setDraw_num(int draw_num) {
        this.draw_num = draw_num;
    }

    public String getSport_club() {
        return sport_club;
    }

    public Fighter setSport_club(String sport_club) {
        this.sport_club = sport_club;
        return this;
    }
}
