package com.dareshuri.libralink.Service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.dareshuri.libralink.Model.Student;

@Service()
public interface StudentService {

    //CREATE
    Student addStudent(Student student);

    // READ
    Iterable<Student> getAllStudents();
    Optional<Student> getStudentByUserId(Long id);
    Optional<Student> getStudentById(Long id);

    //UPDATE
    Student updateGradeByUserId(Long id, String grade);

    //DELETE
    String deleteGradeByUserId(Long id);

}