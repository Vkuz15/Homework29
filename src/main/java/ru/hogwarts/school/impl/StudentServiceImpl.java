package ru.hogwarts.school.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final HashMap<Long, Student> students = new HashMap<>();

    @Override
    public Student add(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student get(Long id) {
        return students.get(id);
    }

    @Override
    public Student edit(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    @Override
    public Student delete(Long id) {
        return students.remove(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public List<Student> getAllStudentsAge(int age) {
        return students.values().stream()
                .filter(student -> student.getAge() == age)
                .toList();
    }
}
