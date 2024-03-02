package com.dareshuri.libralink.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Department;
import com.dareshuri.libralink.Repository.DepartmentRepo;
import com.dareshuri.libralink.Service.DepartmentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired 
    DepartmentRepo departmentRepo;

    // READ
    @Override
    public Iterable<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepo.findById(id);
    }

    // ADD
    @Override
    public Department addDepartment(String name) {
        Department newDepartment = new Department();
        newDepartment.setName(name);
        return departmentRepo.save(newDepartment);
    }

    // UPDATE
    @Override
    public Department updateDepartment(Long id, String newName) {
        Optional<Department> departmentOptional = departmentRepo.findById(id);
        
        if (departmentOptional.isPresent()) {
            Department existingDepartment = departmentOptional.get();
            existingDepartment.setName(newName);
            return departmentRepo.save(existingDepartment);
        } else {
            // Handle not found scenario, you can throw an exception or handle it as per your requirement.
            return null;
        }
    }

    // DELETE
    @Override
    public void deleteDepartment(Long id) {
        departmentRepo.deleteById(id);
    }


    
}
