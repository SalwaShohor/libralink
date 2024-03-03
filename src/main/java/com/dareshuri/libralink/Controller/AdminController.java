package com.dareshuri.libralink.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.Admin;
import com.dareshuri.libralink.Service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired 
    AdminService adminService;

    // CREATE
    @PostMapping("/add")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    // READ
    @GetMapping("/get-all")
    public Iterable<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/get-by-id/{adminId}")
    public Optional<Admin> getAdminById(@PathVariable Long adminId) {
        return adminService.getAdminById(adminId);
    }

    @GetMapping("/get-by-user-id/{userId}")
    public List<Admin> getAdminByUserId(@PathVariable Long userId) {
        return adminService.getAdminByUserId(userId);
    }

    // DELETE
    @DeleteMapping("/delete-by-id/{adminId}")
    public String deleteAdminById(@PathVariable Long adminId){
        return adminService.deleteAdminById(adminId);
    }
      
}
