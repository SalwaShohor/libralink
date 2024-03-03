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
    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    // UPDATE
    @Override
    public Department updateDepartmentNameById(Long id, String newName) {
        Optional<Department> existingDepartment = departmentRepo.findById(id);
        
        if (existingDepartment.isPresent()) {
            Department departmentToUpdate = existingDepartment.get();
            departmentToUpdate.setName(newName);
            return departmentRepo.save(departmentToUpdate);
        } else {
            return null;
        }
    }

    // DELETE
    @Override
    public String deleteDepartmentById(Long id) {
        Optional<Department> departmentOptional = departmentRepo.findById(id);

        if(departmentOptional.isPresent()){
            Department departmentToDelete = departmentOptional.get();
            departmentRepo.delete(departmentToDelete);
            return String.format("Department with id %d successfully deleted!",id);
        }
        
        return String.format("Department with id %d is not found!",id);

    }


    
}
