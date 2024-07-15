package ru.hogwarts.school.model;

import jakarta.persistence.*;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Student extends School{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)")
    private Faculty faculty;
    private int age;

    @OneToOne(mappedBy = "student")
    @JoinColumn(name = "student_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private Faculty facultyStudent;

    public Student(Long id, String name, Integer age) {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    public Faculty getService() {
        return this.faculty;
    }

    public Avatar getAvatar() {
        return avatar;
    }
}
