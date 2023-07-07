package com.darc.schoolapp.repository;

import com.darc.schoolapp.entity.Guardian;
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
//                .guardianName("Danny")
//                .guardianEmail("danny@yahoo.com")
//                .guardianMobile("283883922922")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void showAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("students = " + studentList);
    }

    @Test
    public void saveStudentWithGuardianInfo() {
        Guardian guardian = Guardian.builder()
                .email("kenny@gmail.com")
                .mobile("13324244444")
                .name("Kenny")
                .build();
        Student student = Student.builder()
                .emailId("weird@gmail.com")
                .firstName("John")
                .lastName("Quiver")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void showStudentByFirstName() {

        List<Student> students =
                studentRepository.findByFirstName("John");

        System.out.println("students = " + students);
    }

    @Test
    public void showStudentByFirstNameContaining() {

        List<Student> students =
                studentRepository.findByFirstNameContaining("ch");

        System.out.println("students = " + students);
    }

    @Test
    public void showStudentBasedonGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Kenny");
        System.out.println("students = " + students);
    }

    @Test
    public void showStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                  "weird@gmail.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void showStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "weird@gmail.com"
                );
        System.out.println("student = " + firstName);
    }
}