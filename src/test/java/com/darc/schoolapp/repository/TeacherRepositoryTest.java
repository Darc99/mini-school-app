package com.darc.schoolapp.repository;

import com.darc.schoolapp.entity.Course;
import com.darc.schoolapp.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository repository;

    @Test
    void saveTeacher() {
        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course course1 = Course.builder()
                .title("Java")
                .credit(2)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Ron")
                .lastName("Salamander")
//                .courses(List.of(course,course1))
                .build();

        repository.save(teacher);
    }
}