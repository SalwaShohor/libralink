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

import com.dareshuri.libralink.Model.Department;
import com.dareshuri.libralink.Service.DepartmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/department")
public class DepartmentController {

     @Autowired
    DepartmentService departmentService;


    //READ
    @GetMapping("/get-all")
    Iterable<Department> getAllUsers(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("get-by-id/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    // ADD
    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    // UPDATE
    @PutMapping("/update-department-name-by-id/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestParam String departmentName) {
        return departmentService.updateDepartmentNameById(id, departmentName);
    }


    // DELETE
    @DeleteMapping("/delete-by-id/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return departmentService.deleteDepartmentById(id);
    }


    
}
