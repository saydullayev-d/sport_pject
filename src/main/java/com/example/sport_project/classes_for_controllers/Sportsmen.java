package com.example.sport_project.classes_for_controllers;

public class Sportsmen {


    String name, sport_club, gender, weight, age_category, age, act;
    int draw_num, reg_num;



    public Sportsmen setName(String name) {
        this.name = name;
        return this;
    }

    public Sportsmen setSport_club(String sport_club) {
        this.sport_club = sport_club;
        return this;
    }

    public Sportsmen setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Sportsmen setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public Sportsmen setAge_category(String age_category) {
        this.age_category = age_category;
        return this;
    }

    public Sportsmen setAge(String age) {
        this.age = age;
        return this;
    }

    public Sportsmen setDraw_num(int draw_num) {
        this.draw_num = draw_num;
        return this;
    }

    public Sportsmen setReg_num(int reg_num) {
        this.reg_num = reg_num;
        return this;
    }

    public Sportsmen setAct(String act) {
        this.act = act;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSport_club() {
        return sport_club;
    }

    public String getGender() {
        return gender;
    }

    public String getWeight() {
        return weight;
    }

    public String getAge_category() {
        return age_category;
    }

    public String getAge() {
        return age;
    }

    public int getDraw_num() {
        return draw_num;
    }

    public int getReg_num() {
        return reg_num;
    }

    public String getAct() {
        return act;
    }

    @Override
    public String toString() {
        return "Sportsmen{" +
                "name='" + name + '\'' +
                ", sport_club='" + sport_club + '\'' +
                ", gender='" + gender + '\'' +
                ", weight='" + weight + '\'' +
                ", age_category='" + age_category + '\'' +
                ", age='" + age + '\'' +
                ", draw_num='" + draw_num + '\'' +
                ", reg_num='" + reg_num + '\'' +
                ", act='" + act + '\'' +
                '}';
    }

    public Sportsmen(String name, String sport_club, String gender, String weight, String age_category, String age, int draw_num, int reg_num, String act) {
        this.name = name;
        this.sport_club = sport_club;
        this.gender = gender;
        this.weight = weight;
        this.age_category = age_category;
        this.age = age;
        this.draw_num = draw_num;
        this.reg_num = reg_num;
        this.act = act;
    }
}
