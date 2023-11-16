package com.example.sport_project.classes_for_controllers;

import java.util.Objects;

public class SportClub {
    int id;
    String name;

    public SportClub(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SportClub(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SportClub other = (SportClub) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
