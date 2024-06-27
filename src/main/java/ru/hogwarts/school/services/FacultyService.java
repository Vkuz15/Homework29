package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Faculty;

import java.util.List;

public interface FacultyService extends GeneralService<Faculty> {

    List<Faculty> getAllFacultyColor(String color);
}
