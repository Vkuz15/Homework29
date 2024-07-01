package ru.hogwarts.school.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.services.FacultyService;

import java.util.List;

@Service
public final class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty add(Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty get(Long id) {
        return facultyRepository.findById(id)
                                .orElse(null);
    }

    @Override
    public Faculty edit(Long id, Faculty faculty) {
        return facultyRepository.findById(id)
                                .map(facultyDb -> {
                                  faculty.setId(id);
                                  return facultyRepository.save(faculty);
                                 })
                                .orElse(null);
    }

    @Override
    public Faculty delete(Long id) {
        return facultyRepository.findById(id)
                                .map(faculty -> {
                                    facultyRepository.deleteById(id);
                                    return faculty;
                                })
                                .orElse(null);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public List<Faculty> getAllFacultyColor(String color) {
        return facultyRepository.findFacultiesByColor(color);
    }

    @Override
    public List<Faculty> findFacultyByName(String filter) {
        return List.of();
    }
}
