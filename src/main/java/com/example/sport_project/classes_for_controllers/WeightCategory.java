package com.example.sport_project.classes_for_controllers;

import java.util.Objects;

public class WeightCategory {
    int id;
    String weight;

    public WeightCategory(int id, String weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public WeightCategory(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WeightCategory other = (WeightCategory) obj;
        return Objects.equals(weight, other.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
