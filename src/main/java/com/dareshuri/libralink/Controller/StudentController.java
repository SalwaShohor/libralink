package com.dareshuri.libralink.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.Student;
import com.dareshuri.libralink.Service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get-by-userid/{id}")
    Optional<Student> getStudentByUserId(@PathVariable Long id){
        return studentService.getStudentByUserId(id);
    }

    @GetMapping("/get-all")
    Iterable<Student> getAllUsers(){
        return studentService.getAllStudents();
    }

    @GetMapping("get-by-id/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    
}

