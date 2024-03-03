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
    Department addDepartment(Department department);

    // UPDATE
    Department updateDepartmentNameById(Long id, String newName);

    // DELETE
    String deleteDepartmentById(Long id);
    
}
