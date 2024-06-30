package ru.hogwarts.school.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.services.StudentService;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        return studentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Student edit(Long id, Student student) {
        return studentRepository.findById(id)
                .map(facultyDb -> {
                    student.setId(id);
                    return studentRepository.save(student);
                })
                .orElse(null);
    }

    @Override
    public Student delete(Long id) {
        return studentRepository.findById(id)
                .map(faculty -> {
                    studentRepository.deleteById(id);
                    return faculty;
                })
                .orElse(null);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsAge(int age) {
        return studentRepository.findStudentsByAge(age);
    }
}
