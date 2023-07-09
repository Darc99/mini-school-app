package com.darc.schoolapp.repository;

import com.darc.schoolapp.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    void getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses = " + courses);
    }
}