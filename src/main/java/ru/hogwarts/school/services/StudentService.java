package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService extends GeneralService<Student>{

    List<Student> getAllStudentsAge(int minAge, int maxAge);

    Faculty getFaculty(Long id);
}