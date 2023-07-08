package com.darc.schoolapp.repository;

import com.darc.schoolapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndAndLastName(String firstName, String lastName);

//    JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);


//    JPQL - Native Query
    @Query(
           value = "SELECT * from tbl_student s where s.email_address = ?1",
           nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);



//    Query named params
    @Query(
            value = "SELECT * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNamedParam(@Param("emailId") String emailId);
}
