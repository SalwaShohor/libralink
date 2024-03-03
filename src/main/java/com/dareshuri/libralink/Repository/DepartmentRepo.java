package com.dareshuri.libralink.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.Department;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends CrudRepository<Department,Long> {
    
    // READ
    Iterable<Department> findAll();
    Optional<Department> findById(Long departmentId);
    Optional<Department> findAllByName(String departmentName);

}
