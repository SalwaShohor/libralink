package com.dareshuri.libralink.Controller;

import java.util.Map;
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

import com.dareshuri.libralink.Model.Department;
import com.dareshuri.libralink.Service.DepartmentService;


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
    public ResponseEntity<Department> addDepartment(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        Department newDepartment = departmentService.addDepartment(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDepartment);
    }



    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Map<String, String> departmentDetails) {
        String name = departmentDetails.get("name");
        Department updatedDepartment = departmentService.updateDepartment(id, name);
        return ResponseEntity.ok(updatedDepartment);
    }



    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }


    
}
