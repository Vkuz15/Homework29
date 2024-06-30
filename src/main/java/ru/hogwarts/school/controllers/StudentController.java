package ru.hogwarts.school.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.add(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.get(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAll();
    }

    @GetMapping("getAge/{age}")
    public List<Student> getAllStudentsAge(@PathVariable int age) {
        return studentService.getAllStudentsAge(age);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Long id, @RequestBody Student student) {
        Student editStudent = studentService.edit(id, student);
        if (editStudent != null) {
            return ResponseEntity.ok(editStudent);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student deletedObject = studentService.delete(id);
        if (deletedObject != null) {
            return ResponseEntity.ok(deletedObject);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
