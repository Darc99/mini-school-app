package com.darc.schoolapp.repository;

import com.darc.schoolapp.entity.Course;
import com.darc.schoolapp.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Fred")
                .lastName("Jones")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 2);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =  courseRepository
                .findAll(secondPageWithTwoRecords)
                .getTotalElements();

        long totalPages = courseRepository
                .findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("List of courses = " + courses);
        System.out.println("total elements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
    }

    @Test
    void findALlSorting() {
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );

        Pageable sortCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );

        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,2,
                Sort.by("title")
                .descending()
                .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository
                .findAll(sortByTitle)
                .getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    void showFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0,10);
        List<Course> courses = courseRepository
                .findByTitleContaining(
                        "D",
                        firstPageTenRecords
                ).getContent();
        System.out.println("course = " + courses);
    }
}