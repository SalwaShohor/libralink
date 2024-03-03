package com.dareshuri.libralink.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Long>{
    
    // READ
    List<Admin> findAllByUserId(Long userId);
    
}
