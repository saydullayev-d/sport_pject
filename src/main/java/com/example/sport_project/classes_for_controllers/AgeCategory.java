package com.example.sport_project.classes_for_controllers;

public class AgeCategory {

    int id;

    String age;

    public AgeCategory(int id, String age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }
}