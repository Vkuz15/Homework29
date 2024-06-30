package ru.hogwarts.school.model;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Faculty extends School {

    private String color;

    public Faculty(String name) {
        super(name);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "color='" + color + '\'' +
                '}';
    }
}

