package com.example.sport_project.classes_for_controllers;

import java.util.Objects;

public class AgeCategory {

    int id;

    String age;

    public AgeCategory(int id, String age) {
        this.id = id;
        this.age = age;
    }

    public AgeCategory(String age) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AgeCategory other = (AgeCategory) obj;
        return id == other.id && Objects.equals(age, other.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age != null ? age.hashCode() : 0);
    }

}