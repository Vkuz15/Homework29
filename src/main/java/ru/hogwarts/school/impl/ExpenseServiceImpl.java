package ru.hogwarts.school.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entity.ExpenseByStudentService;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.services.ExpenseService;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private StudentRepository studentRepository;

    private final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);

    public ExpenseServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        logger.info("Get all Students");
        return studentRepository.findAll();
    }

    public void createExpenses(Student student) {
        logger.info("Create expenses by Student");
        studentRepository.save(student);
    }

    public void deleteExpenses(Long id) {
        logger.info("The Expenses has been deleted");
        studentRepository.deleteById(id);
    }

    public List<ExpenseByStudentService> getExpensesAllStudents() {
        logger.info("All Students expenses has been received");
        return studentRepository.getExpensesAllStudents();
    }

    public Integer getAllStudentsFromSchool() {
        logger.info("Get all Students from School has been received");
        return studentRepository.getAllStudentsFromSchool();
    }

    public Integer getAverageAgeStudents() {
        logger.info("Get average age Students");
        return studentRepository.getAverageAgeStudents();
    }

    public List<Student> getLastFiveStudents() {
        logger.info("Get last five Students");
        return studentRepository.getLastFiveStudents();
    }
}
