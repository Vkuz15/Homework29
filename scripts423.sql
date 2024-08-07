SELECT student.id, student.name, faculty_student.id, faculty.name
FROM students
LEFT JOIN id ON student.faculty_id = students.faculty_id

SELECT student.id, avatar.id
FROM students
JOIN avatar ON student.id = students.student_id
