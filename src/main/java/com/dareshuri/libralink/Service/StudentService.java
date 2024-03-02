package com.dareshuri.libralink.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Student;

@Service()
public interface StudentService {

    // READ
    Iterable<Student> getAllStudents();
    Optional<Student> getStudentByUserId(Long id);
    Optional<Student> getStudentById(Long id);
  

}