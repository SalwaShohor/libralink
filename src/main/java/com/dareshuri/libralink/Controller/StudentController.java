package com.dareshuri.libralink.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dareshuri.libralink.Model.Student;
import com.dareshuri.libralink.Service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    //CREATE
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    //READ
    @GetMapping("/get-by-userid/{id}")
    Optional<Student> getStudentByUserId(@PathVariable Long id){
        return studentService.getStudentByUserId(id);
    }

    @GetMapping("/get-all")
    Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    //UPDATE
    @PutMapping("/update-by-userid/{id}")
    public Student updateGradeByUserId(@PathVariable Long id, @RequestParam String grade) {
        return studentService.updateGradeByUserId(id, grade);
    }

    //DELETE
    @DeleteMapping("/delete-by-userid/{id}")
    public String deleteGradeByUserId(@PathVariable Long id){
        return studentService.deleteGradeByUserId(id);
    }
    
}

