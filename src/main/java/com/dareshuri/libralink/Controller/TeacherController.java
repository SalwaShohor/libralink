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

import com.dareshuri.libralink.Service.UserService;
import com.dareshuri.libralink.Model.Teacher;
import com.dareshuri.libralink.Service.TeacherService;

@CrossOrigin(origins = "http://localhost:4200")
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

    // ADD
    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    // UPDATE
    @PutMapping("/update-department-id-by-id/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestParam Long departmentId) {
        return teacherService.updateDepartmentIdById(id, departmentId);
    }

    // DELETE
    @DeleteMapping("/delete-by-id/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        return teacherService.deleteTeacherById(id);
    }


    
}
