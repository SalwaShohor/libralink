package com.dareshuri.libralink.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.User;
import com.dareshuri.libralink.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // CREATE
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // READ
    @GetMapping("/get-all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("get-by-id/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("get-by-username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("get-by-email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("get-all-by-role/{role}")
    public Iterable<User> getAllUserByRole(@PathVariable String role) {
        return userService.getAllUserByRole(role);
    }

    // UPDATE
    @PutMapping("update-profile-info-by-id/{id}")
    public User updatePhoneNumberById(@PathVariable Long id, @RequestBody Map<String, String> inpMap) {
        return userService.updateProfileInfoById(id, inpMap);
    }

    @PutMapping("update-password-by-id/{id}")
    public User updatePasswordById(@PathVariable Long id, @RequestParam String password) {
        return userService.updatePasswordById(id, password);
    }

    @PutMapping("update-password-by-email/{email}")
    public User updatePasswordByEmail(@PathVariable String email, @RequestParam String password) {
        return userService.updatePasswordByEmail(email, password);
    }

    // DELETE
    @DeleteMapping("delete-by-id/{id}")
    public String deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody Map<String,String> map) {
        return userService.login(map);
    }
    
}
