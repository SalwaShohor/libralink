package com.dareshuri.libralink.Service.Impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.User;
import com.dareshuri.libralink.Repository.UserRepo;
import com.dareshuri.libralink.Service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired UserRepo userRepo;

    // CREATE
    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    // READ
    @Override
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Iterable<User> getAllUserByRole(String username) {
        return userRepo.findAllByRole(username);
    }

    // UPDATE
    @Override
    public User updateProfileInfoById(Long id, Map<String, String> inpMap) {
        Optional<User> userOptional = userRepo.findById(id);
        
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setUsername(inpMap.get("username"));
            user.setPhoneNumber(inpMap.get("phoneNumber"));
            return userRepo.save(user);
        }

        return null;
    }

    @Override
    public User updatePasswordById(Long id, String password) {
        Optional<User> userOptional = userRepo.findById(id);
        
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setPassword(password);
            return userRepo.save(user);
        }

        return null;
    }

    @Override
    public User updatePasswordByEmail(String email, String password) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setPassword(password);
            return userRepo.save(user);
        }

        return null;
    }

    // DELETE
    @Override
    public String deleteUserById(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        
        if(userOptional.isPresent()){
            User user = userOptional.get();
            userRepo.delete(user);
            return String.format("User with id %d successfully deleted!", id);
        }

        return String.format("User with id %d not found!", id);
    }

    



    
}
