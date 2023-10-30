package com.example.sport_project.classes_for_controllers;

public class Fighter {
    String name;
    int draw_num;

    public Fighter(String name, int draw_num) {
        this.name = name;
        this.draw_num = draw_num;
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
}
