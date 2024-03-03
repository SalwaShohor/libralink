package com.dareshuri.libralink.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Admin;
import com.dareshuri.libralink.Repository.AdminRepo;
import com.dareshuri.libralink.Service.AdminService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    // CREATE
    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    // READ
    @Override
    public Iterable<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long adminId) {
        return adminRepo.findById(adminId);
    }

    @Override
    public List<Admin> getAdminByUserId(Long userId) {
        return adminRepo.findAllByUserId(userId);
    }

    // DELETE
    @Override
    public String deleteAdminById(Long id) {
        Optional<Admin> adminToDeleteOptional = adminRepo.findById(id);

        if (adminToDeleteOptional.isPresent()) {
            Admin adminToDelete = adminToDeleteOptional.get();
            adminRepo.delete(adminToDelete);
            return String.format("Admin with id %d successfully deleted!", adminToDelete.getAdminId());
        }
        return String.format("Admin not found!");
    }


}
