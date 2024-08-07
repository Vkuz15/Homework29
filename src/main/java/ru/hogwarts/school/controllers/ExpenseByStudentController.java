package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.entity.ExpenseByStudentService;
import ru.hogwarts.school.impl.ExpenseServiceImpl;
import ru.hogwarts.school.model.Student;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseByStudentController {

    private final ExpenseServiceImpl expenseService;

    ExpenseByStudentController(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/by-students")
    public ResponseEntity<List<ExpenseByStudentService>> getExpensesByStudents() {
        List<ExpenseByStudentService> students = expenseService.getExpensesAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getAllStudentsFromSchool() {
        int count = expenseService.getAllStudentsFromSchool();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/average-age")
    public ResponseEntity<Integer> getAverageAgeStudents() {
        int average = expenseService.getAverageAgeStudents();
        return ResponseEntity.ok(average);
    }

    @GetMapping("/last-five")
    public ResponseEntity<List<Student>> getLastFiveStudents() {
        List<Student> lastFive = expenseService.getLastFiveStudents();
        return ResponseEntity.ok(lastFive);
    }
}
