package ru.hogwarts.school.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Faculty extends School {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)")
    private Faculty faculty;

    private String color;

    @OneToMany(mappedBy = "facultyStudent")
    private List<Student> students;

    public Faculty(String name) {
    }

    public String getColor() {
        this.color = color;
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

