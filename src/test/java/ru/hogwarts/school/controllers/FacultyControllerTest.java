package ru.hogwarts.school.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.School;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class FacultyControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    FacultyController facultyController;

    @Test
    void addFaculty() {
        Faculty faculty = new Faculty("Griffendor");
        faculty.setColor("Orange");

        Faculty facultySave = testRestTemplate.postForObject("/faculty", faculty, Faculty.class);
        System.out.println(facultySave.getId());

        ResponseEntity<Faculty> forEntity = testRestTemplate.getForEntity("/faculty/"+ facultySave.getId(), Faculty.class);
        Assertions.assertEquals(OK, forEntity.getStatusCode());
        Faculty body = forEntity.getBody();
        Assertions.assertNotNull(body);

        Assertions.assertEquals("Orange", body.getColor());
        Assertions.assertEquals("Griffendor", body.getName());
    }

    @Test
    void getFaculty() {
        Faculty faculty = new Faculty("Griffendor");
        faculty.setColor("Orange");

        Faculty facultySave = testRestTemplate.postForObject("/faculty", faculty, Faculty.class);
        System.out.println(facultySave.getId());

        ResponseEntity<Faculty> forEntity = testRestTemplate.getForEntity("/faculty/"+ facultySave.getId(), Faculty.class);
        Assertions.assertEquals(OK, forEntity.getStatusCode());
        Faculty body = forEntity.getBody();
        Assertions.assertNotNull(body);

        Assertions.assertEquals("Orange", body.getColor());
        Assertions.assertEquals("Griffendor", body.getName());
    }

    @Test
    void getNotFound() {
        ResponseEntity<Faculty> forEntity = testRestTemplate.getForEntity("/faculty/-5", Faculty.class);
        Assertions.assertEquals(NOT_FOUND, forEntity.getStatusCode());
    }

    @Test
    void getAllFaculty() {
        {
            Faculty faculty = new Faculty("Griffendor");
            faculty.setColor("Orange");

            Faculty facultySave = testRestTemplate.postForObject("/faculty", faculty, Faculty.class);
            System.out.println(facultySave.getId());
        }
        {
            Faculty faculty = new Faculty("Slizerin");
            faculty.setColor("Green");

            Faculty facultySave = testRestTemplate.postForObject("/faculty", faculty, Faculty.class);
            System.out.println(facultySave.getId());
        }

        Faculty[] forObject = testRestTemplate.getForObject("/faculty", Faculty[].class);
        Assertions.assertEquals(2, forObject.length);
        Assertions.assertEquals("Orange", forObject[0].getColor());
        Assertions.assertEquals("Green", forObject[1].getColor());
    }

    @Test
    void getAllFacultyColor() {
        Faculty faculty = new Faculty("Slizerin");
        faculty.setColor("Green");

        Faculty facultySave = testRestTemplate.postForObject("/faculty", faculty, Faculty.class);
        System.out.println(facultySave.getId());

        Faculty[] forObject = testRestTemplate.getForObject("/faculty/color/green", Faculty[].class);
            Assertions.assertEquals(1, forObject.length);
            Assertions.assertEquals("Green", forObject[0].getColor());
    }

    @Test
    void editFaculty() {
        Faculty faculty = new Faculty("Griffendor");
        faculty.setColor("Orange");

        Faculty facultySave = testRestTemplate.postForObject("/faculty", faculty, Faculty.class);
        System.out.println(facultySave.getId());

        testRestTemplate.put("/faculty/" + facultySave.getId(), faculty.getColor("Black"), Faculty.class);

        ResponseEntity<Faculty> forEntity = testRestTemplate.getForEntity("/faculty/"+ facultySave.getId(), Faculty.class);
        Assertions.assertEquals(OK, forEntity.getStatusCode());
        Faculty body = forEntity.getBody();
        Assertions.assertEquals("Black", body.getColor());
    }

    @Test
    void deleteFaculty() {
        Faculty faculty = new Faculty("Griffendor");
        faculty.setColor("Orange");

        Faculty facultySave = testRestTemplate.postForObject("/faculty", faculty, Faculty.class);
        System.out.println(facultySave.getId());

        testRestTemplate.delete("/faculty/" + facultySave.getId(), Faculty.class);

        ResponseEntity<Faculty> forEntity = testRestTemplate.getForEntity("/faculty/"+ facultySave.getId(), Faculty.class);
        Assertions.assertEquals(OK, forEntity.getStatusCode());
        Faculty body = forEntity.getBody();
        Assertions.assertEquals("Orange", body.getColor());
    }
}