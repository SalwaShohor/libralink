package com.dareshuri.libralink.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Admin;

@Service()
public interface AdminService {

    // CREATE
    Admin addAdmin(Admin admin);

    // READ
    Iterable<Admin> getAllAdmins();
    Optional<Admin> getAdminById(Long adminId);
    List<Admin> getAdminByUserId(Long userId);

    // DELETE 
    String deleteAdminById(Long adminId);
    
    
}
