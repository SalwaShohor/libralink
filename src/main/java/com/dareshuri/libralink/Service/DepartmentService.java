package com.dareshuri.libralink.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Department;

@Service()
public interface DepartmentService {

    // READ
    Iterable<Department> getAllDepartments();
    Optional<Department> getDepartmentById(Long id);

    // ADD
    Department addDepartment(String name);

    // UPDATE
    Department updateDepartment(Long id, String newName);

    // DELETE
    void deleteDepartment(Long id);
    
}
