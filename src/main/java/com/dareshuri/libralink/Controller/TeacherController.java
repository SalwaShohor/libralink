package com.dareshuri.libralink.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Service.UserService;
import com.dareshuri.libralink.Model.Teacher;
import com.dareshuri.libralink.Service.TeacherService;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;

    //READ

    @GetMapping("/get-all")
    public Iterable<Teacher> getAllUsers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/get-by-userid/{id}")
    public Optional<Teacher> getTeacherByUserId(@PathVariable Long id) {
        return teacherService.getTeacherByUserId(id);
    }

    @GetMapping("get-by-id/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    // CREATE
    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }



    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        try {
            teacherService.updateTeacher(id, updatedTeacher);
            return ResponseEntity.ok("Teacher updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating teacher");
        }
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) {
        try {
            teacherService.deleteTeacher(id);
            return ResponseEntity.ok("Teacher deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting teacher");
        }
    }


    
}
