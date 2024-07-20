package ru.hogwarts.school.model;

import jakarta.persistence.*;

import java.util.Objects;

@MappedSuperclass
public abstract class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String color;

    public School(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    protected School() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id) && Objects.equals(name, school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getColor(String color) {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}