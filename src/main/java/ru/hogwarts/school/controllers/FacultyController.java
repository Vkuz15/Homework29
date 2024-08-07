package ru.hogwarts.school.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.services.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.get(id);
        if (faculty == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyService.getAll();
    }

    @GetMapping(path = "getColor/{color}")
    public List<Faculty> getAllFacultyColor(@PathVariable String color) {
        return facultyService.getAllFacultyColor(color);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Faculty> editFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        Faculty editFaculty = facultyService.edit(id, faculty);
        if (editFaculty != null) {
            return ResponseEntity.ok(editFaculty);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(path = "/faculty/{color}")
    public ResponseEntity<List<Faculty>> findByFacultyNameColor(@RequestParam("filter") String filter) {
        List<Faculty> filteredFaculties = facultyService.findFacultyByName(filter);
        if (filteredFaculties.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filteredFaculties);
    }

    @GetMapping(path = "/faculty/{name}")
    public ResponseEntity<List<Faculty>> findByFacultyName(@RequestParam("filter") String filter) {
        List<Faculty> filteredFaculties = facultyService.findFacultyByName(filter);
        if (filteredFaculties.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filteredFaculties);
    }

    @GetMapping(path = "/long-name")
    public String getFacultyWithLongName() {
        return facultyService.getFacultyWithLongName();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        Faculty deletedObject = facultyService.delete(id);
        if (deletedObject != null) {
            return ResponseEntity.ok(deletedObject);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
