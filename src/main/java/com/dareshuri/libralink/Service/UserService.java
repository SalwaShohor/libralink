package com.dareshuri.libralink.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.User;

@Service()
public interface UserService {

    // READ
    Iterable<User> getAllUsers();
    Optional<User> getUserById(Long id);

}
