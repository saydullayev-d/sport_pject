package com.example.sport_project.classes_for_controllers;
import java.util.Objects;



public class Sportsmen {


    String name, sport_club, gender, weight, age_category, age, act;
    int draw_num, reg_num;

    public Sportsmen(String name, String sport_club, String gender, String weight, String age_category, String age, int draw_num, int reg_num, String act) {
        this.name = name;
        this.sport_club = sport_club;
        this.gender = gender;
        this.weight = weight;
        this.age_category = age_category;
        this.age = age;
        this.act = act;
        this.draw_num = draw_num;
        this.reg_num = reg_num;
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

    public String getAct() {
        return act;
    }

    public Sportsmen() {
    }

    public int getDraw_num() {
        return draw_num;
    }

    public int getReg_num() {
        return reg_num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSport_club(String sport_club) {
        this.sport_club = sport_club;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setAge_category(String age_category) {
        this.age_category = age_category;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public void setDraw_num(int draw_num) {
        this.draw_num = draw_num;
    }

    public void setReg_num(int reg_num) {
        this.reg_num = reg_num;
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




        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Sportsmen other = (Sportsmen) obj;

            // Сравниваем поля объектов
            return Objects.equals(name, other.name) &&
                    Objects.equals(sport_club, other.sport_club) &&
                    Objects.equals(gender, other.gender) &&
                    Objects.equals(weight, other.weight) &&
                    Objects.equals(age_category, other.age_category) &&
                    Objects.equals(age, other.age) &&
                    draw_num == other.draw_num &&
                    reg_num == other.reg_num &&
                    Objects.equals(act, other.act);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, sport_club, gender, weight, age_category, age, draw_num, reg_num, act);
        }




}
