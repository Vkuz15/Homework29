package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.entity.ExpenseByStudentService;
import ru.hogwarts.school.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByAge(int minAge, int maxAge);

    List<Student> findStudentsAge(int age);

    @Query(value = "SELECT name, SUM(id) as id FROM expenses GROUP BY name", nativeQuery = true)
    List<ExpenseByStudentService> getExpensesAllStudents();

    @Query(value = "SELECT count(*) FROM student", nativeQuery = true)
    Integer getAllStudentsFromSchool();

    @Query(value = "SELECT AVG(age) as age FROM student", nativeQuery = true)
    Integer getAverageAgeStudents();

    @Query(value = "SELECT * FROM student ORDER BY is DESC LIMIT 5", nativeQuery = true)
    List<Student> getLastFiveStudents();
}