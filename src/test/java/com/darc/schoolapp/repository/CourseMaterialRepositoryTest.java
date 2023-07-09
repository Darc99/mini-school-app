package com.darc.schoolapp.repository;

import com.darc.schoolapp.entity.Course;
import com.darc.schoolapp.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    void saveCourseMaterial() {
        Course course =
                Course.builder()
                        .title("Devops")
                        .credit(3)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("darc.com")
                        .course(course)
                        .build();
        repository.save(courseMaterial);
    }

    @Test
    void getAllCourseMaterials() {
        List<CourseMaterial>  courseMaterials = repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}