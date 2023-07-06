package com.darc.schoolapp.repository;

import com.darc.schoolapp.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//do not use @@SpringBootTest in a normal setting to avoid storing tested data in our db
// use @DataJpaTest instead so the data can be flushed after testing
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("lenny@gmail.com")
                .firstName("Ugochuwu")
                .lastName("Anyanwu")
                .guardianName("Danny")
                .guardianEmail("danny@yahoo.com")
                .guardianMobile("283883922922")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void showAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("students = " + studentList);
    }
}