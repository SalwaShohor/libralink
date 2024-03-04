package com.dareshuri.libralink.Service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.dareshuri.libralink.Model.User;

@Service()
public interface UserService {

    // CREATE
    User addUser(User user);
    
    // READ
    Iterable<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    Iterable<User> getAllUserByRole(String role);

    // UPDATE
    User updateProfileInfoById(Long id, Map<String,String> inpMap);
    User updatePasswordById(Long id, String password);
    User updatePasswordByEmail(String email, String password);

    // DELETE
    String deleteUserById(Long id);

    //LOGIN
    User login(Map<String,String> map);
    
}
