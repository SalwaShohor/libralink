package com.dareshuri.libralink.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.User;
import com.dareshuri.libralink.Service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // READ
    @GetMapping("/get-all")
    Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("get-by-id")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    
}
