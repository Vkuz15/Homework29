package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Student;

import java.util.List;

public interface ExpenseService {

    List<Student> getAllStudents();

    void createExpenses(Student student);

    void deleteExpenses(Long id);
}
