package ru.hogwarts.school.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entity.ExpenseByStudentService;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.services.ExpenseService;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private StudentRepository studentRepository;

    public ExpenseServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void createExpenses(Student student) {
        studentRepository.save(student);
    }

    public void deleteExpenses(Long id) {
        studentRepository.deleteById(id);
    }

    public List<ExpenseByStudentService> getExpensesAllStudents() {
        return studentRepository.getExpensesAllStudents();
    }

    public Integer getAllStudentsFromSchool() {
        return studentRepository.getAllStudentsFromSchool();
    }

    public Integer getAverageAgeStudents() {
        return studentRepository.getAverageAgeStudents();
    }

    public List<Student> getLastFiveStudents() {
        return studentRepository.getLastFiveStudents();
    }
}
